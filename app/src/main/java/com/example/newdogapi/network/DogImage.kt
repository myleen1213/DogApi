package com.example.newdogapi.network

import com.squareup.moshi.Json

/*Taking a JSON value and getting the data from API(NEW url everytime
its clicked) we are only getting back the image not the status*/

data class DogImage ( @Json(name ="message") val imgSrcUrl: String)

