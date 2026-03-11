package com.example.bookinf.data

data class Room(
    val Title: String,
    val Score: Float,
    val Reviews: Int,
    val Distance: Int,
    val stars: Int,
    val DiscountedCost: Int,
    val Cost: Int,
    val PrePayment : Boolean
){
    fun TextRate(): String {
        var result: String = "N/A"
        if(Score>7) {
            result = "Good"
        }
        if(Score>8){
            result = "Fabulous"
        }
        return result
    }
}
