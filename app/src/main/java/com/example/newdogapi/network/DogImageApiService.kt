package com.example.newdogapi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/breeds/image/"

//Add to print out network requests in and responses in logcat

private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

//allows to break down response we receive into JSON so we can use data
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//when we get a OK response print it to the logcat take JSON and adapt it to kotlin
private val retrofit = Retrofit.Builder()
    .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//Gets ONE random dog image.  the end of the URL
interface DogImageApiService {
    @GET("random")
    suspend fun getRandomDogImage() : DogImage

}

//creates a service so we can use yhe @get random function on top

object DogImageApi{
    val retrofitService: DogImageApiService by lazy { retrofit.create(DogImageApiService::class.java)}
}

