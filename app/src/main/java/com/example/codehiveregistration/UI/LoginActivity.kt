package com.example.codehiveregistration.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.codehiveregistration.Models.Constants
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.ViewModels.UserViewModel
import com.example.codehiveregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val userViewModel: UserViewModel by viewModels()
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        sharedPrefs = getSharedPreferences(Constants.Prefs_File, Context.MODE_PRIVATE)

        clickButton()


    }

    fun clickButton(){
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail2.text.toString()
            val password = binding.etPass2.text.toString()
            var error = false
            if (email.isEmpty() && password.isEmpty()) {
                var error = true
                binding.etEmail2.setError("Email address required")
                binding.etPass2.setError("Password required")
            } else {
                val logRequest = LoginRequest(email = email, password = password)
                userViewModel.studentLogin(logRequest)
            }
        }
    }
    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, { loginResponse ->
            var editor = sharedPrefs.edit()
            editor.putString(Constants.Access_Token, loginResponse.accessToken)
            editor.putString(Constants.Student_ID, loginResponse.studentId)
            editor.apply()
            binding.pbLoading2.visibility = View.GONE
            Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG)
                .show()
            var intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)

        })
        userViewModel.logErrorLiveData.observe(this, { error ->
            binding.pbLoading2.visibility = View.GONE
            Toast.makeText(baseContext, "Login  is unsuccessful", Toast.LENGTH_LONG)
                .show()
        })
    }

}
