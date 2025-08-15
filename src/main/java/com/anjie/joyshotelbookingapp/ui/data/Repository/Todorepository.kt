package com.anjie.joyshotelbookingapp.ui.data.Repository
import ads_mobile_sdk.eq
import com.anjie.joyshotelbookingapp.ui.data.models.Todo
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.UploadStatus
import io.github.jan.supabase.storage.storage
import io.github.jan.supabase.storage.uploadAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.selects.select
import java.util.Locale.filter

sealed class UploadResult {
    data class Progress(val percent: Float) : UploadResult()
    data class Success(val url: String) : UploadResult()
}

class TodoRepository : TodoService {

    val supabase = createSupabaseClient(
        supabaseUrl ="https://dbzwloqdjovxjwooctdq.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRiendsb3Fkam92eGp3b29jdGRxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTUyNTQwODAsImV4cCI6MjA3MDgzMDA4MH0.BQzv34AWsuN-9oLCsJFK3Awqa6zGSLwumwP5FBgn3qY"
    ) {
        install(Auth)
        install(Postgrest)
        install(Storage)
    }

    override suspend fun createTask(todo: Todo): Todo? {
        val result = supabase.from("todo").insert(todo) {
            select()
        }.decodeSingle<Todo>()
        return result
    }

    override suspend fun getAllTasks(): List<Todo> {
        val task = supabase.from("todo").select().decodeList<Todo>()
        return task
    }

    override suspend fun getTask(id: Int): Todo? {
        val todo = supabase.from("todo").select() {
            filter {
                Todo::id eq id
            }
        }.decodeAsOrNull<Todo>()
        return todo
    }

    override suspend fun updateTask(todo: Todo): Todo? {
        val todo = supabase.from("todo").update(
            todo
        ) {
            select()
            filter {
                eq("id", todo.id!!)
            }
        }.decodeSingle<Todo>()
        return todo
    }

    override suspend fun insertImage(
        fileName: String,
        fileBytes: ByteArray
    ): Flow<UploadResult>{
        val bucket = supabase.storage.from("todo/images")

        return bucket.uploadAsFlow(fileName, fileBytes)
            .map{ status->
                when (status) {
                    is UploadStatus.Progress -> {
                        val percent = status.totalBytesSend.toFloat() / status.contentLength * 100
                        UploadResult.Progress(percent)

                    }

                    is UploadStatus.Success -> {
                        println("Upload successful!")
                        UploadResult.Success(bucket.publicUrl(fileName))
                    }
                }
            }
    }


    override suspend fun deleteTask(id: Int): Boolean {
        supabase.from("todo").delete {
            filter {
                eq("id", id)
            }
        }
        return getTask(id) == null
    }
}

private fun SupabaseClient.from(string: String) {}


