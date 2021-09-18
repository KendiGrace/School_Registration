package com.example.studentregistration.api

import android.content.Context
import com.example.codehiveregistration.Api.SessionManager
import okhttp3.Interceptor
import okhttp3.Response


class OAuthInterceptor(context: Context) : Interceptor {
    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        //adding access token if saved to the request
        sessionManager.fetchAccessToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}
