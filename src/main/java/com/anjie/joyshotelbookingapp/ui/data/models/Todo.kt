package com.anjie.joyshotelbookingapp.ui.data.models
import kotlinx.serialization.Serializable

    @Serializable
    data class Todo(
        val id:Int? =null,
        val createdAt:String? = null,
        val title:String,
        val description:String,
        val media: String,
        val isComplete: Boolean? = false,
        val dueDate:Long,
    )