package com.example.codehiveregistration.Api

import android.content.Context
import android.content.SharedPreferences
import com.example.codehiveregistration.R


//session manager to save and fetch data from SharedPreferences
class SessionManager (context: Context){
    private var prefs :SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE)

    companion object{
        const val ACCESS_TOKEN = "access_token"
    }


    //    Saving access token
    fun saveAccessToken(token:String){
        val editor = prefs.edit()
        editor.putString(ACCESS_TOKEN,token)
        editor.apply()
    }


    //    Fetching the access token
    fun fetchAccessToken():String?{
        return prefs.getString(ACCESS_TOKEN,null)
    }
}