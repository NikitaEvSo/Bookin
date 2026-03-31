package com.example.bookinf.data
fun rememberRooms(): List<Room> =
    listOf(
        Room(
            id = 1,
            title = "NH Barcelona Eixample",
            score = 7.9f,
            reviews = 2023,
            distanceMeters = 1300,
            stars = 3,
            discountedCost = 200,
            originalCost = 281,
            tags = listOf("Limited-time Deal"),
            isPrepaymentNeeded = false,
        ),
        Room(
            id = 2,
            title = "Hotel Conqueridor",
            score = 7.9f,
            reviews = 4303,
            distanceMeters = 450,
            stars = 4,
            discountedCost = 99,
            originalCost = 111,
            isPrepaymentNeeded = true,
        ),
        Room(
            id = 3,
            title = "Lindala",
            score = 7.9f,
            reviews = 1720,
            distanceMeters = 450,
            stars = 4,
            discountedCost = 70,
            originalCost = 281,
            isPrepaymentNeeded = true,
        )
    )

