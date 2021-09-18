package com.example.codehiveregistration.Api

<<<<<<< HEAD
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.codehiveregistration.CodeHiveRegApplication
import okhttp3.OkHttpClient
=======
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
<<<<<<< HEAD
    val client = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(CodeHiveRegApplication.appContext))
        .build()
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.244.243.129")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }

}
=======
   var retrofit=Retrofit.Builder()
   .baseUrl("http://13.244.243.129")
.addConverterFactory(GsonConverterFactory.create())
    .build()

  fun <T> buildApiClient(ApiInterface:Class<T>):T{
        return retrofit.create(ApiInterface)
   }

}

>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
