package com.anjie.joyshotelbookingapp.ui.data

import com.anjie.joyshotelbookingapp.R


data class Hotel(
    val id: Int,
    val name: String,
    val location: String,
    val image: Int,
    val description: String

) 
    


val sampleHotels  = listOf(

    Hotel(1,"SunShine Resort","Mombasa", R.drawable.serena,"serena"),
    Hotel(2,"Mountain View","Nairobi" ,R.drawable.serena,"serena"),
    Hotel(3,"Serena","Nairobi", R.drawable.serena,"serena"),
    Hotel(4,"FiveStar","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"Bantu African Resort","Eldoret", R.drawable.serena,"serena"),
    Hotel(4,"Best peak Resort","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"Wonders Lodge ","Naivasha", R.drawable.serena,"serena"),
    Hotel(4,"Break Resort","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"Wave Crest Resort","Eldoret", R.drawable.serena,"serena"),
    Hotel(4,"Seaside Escape Resort","Mombasa", R.drawable.serena,"serena"),
    Hotel(5,"Pure Surf Resort","Eldoret", R.drawable.serena,"serena"),
    Hotel(4,"Beach FrontBreeze Resort","Mombasa", R.drawable.serena,"serena"),
    Hotel(5,"The RetreatOasis Resort","Eldoret", R.drawable.serena,"serena"),
    Hotel(4,"Tranquil Resort","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"Coastal Luxe Resort","Eldoret", R.drawable.serena,"serena"),
    Hotel(4,"Tide Resort","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"PalmBreeze Paradise ","Mombasa", R.drawable.serena,"serena"),
    Hotel(4,"Crystal Castle Resort","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"Ruby Retreat Resort","Eldoret", R.drawable.serena,"serena"),
    Hotel(4,"Emerald Estate Resort","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"Topaz Power Resort","Eldoret", R.drawable.serena,"serena"),
    Hotel(4,"Marble Mansion","Nakuru", R.drawable.serena,"serena"),
    Hotel(5,"Opal Oasis Resort","Eldoret", R.drawable.serena,"serena")

)