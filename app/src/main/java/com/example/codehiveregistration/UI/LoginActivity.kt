package com.example.codehiveregistration.UI

<<<<<<< HEAD
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
=======
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Models.LoginResponse
import com.example.codehiveregistration.ViewModels.UserViewModel
import com.example.codehiveregistration.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    val userViewModel:UserViewModel by viewModels()
//    lateinit var etEmail2:EditText
//    lateinit var etPass2:EditText
//    lateinit var btnLogin:Button
//    lateinit var pbLoading2:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        castViews()
        clickButton()

    }
//    fun castViews(){
//        etEmail2=findViewById(R.id.etEmail2)
//        etPass2=findViewById(R.id.etPass2)
//        btnLogin=findViewById(R.id.btnLogin)
//        pbLoading2=findViewById(R.id.pbLoading)
//    }
    fun clickButton(){
        binding.btnLogin.setOnClickListener {
            val email=binding.etEmail2.text.toString()
            val password=binding.etPass2.text.toString()
            if(email.isEmpty() && password.isEmpty()){
                binding.etEmail2.setError("Email address required")
                binding.etPass2.setError("Password required")
            }
            else{
                val logRequest = LoginRequest(email = email, password = password)
              userViewModel.studentLogin(logRequest)
                var intent = Intent(baseContext, CoursesActivity::class.java)
                        startActivity(intent)
//                val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
//                val request = retrofit.studentLogin(logRequest)
//                request.enqueue(object : Callback<LoginResponse> {
//                    override fun onResponse(
//                        call: Call<LoginResponse>,
//                        response: Response<LoginResponse>
//                    ) {
//                        pbLoading2.visibility=View.GONE
//                        if(response.isSuccessful){
//                            Toast.makeText(baseContext,"Login request successful",Toast.LENGTH_SHORT).show()
//                            var intent = Intent(baseContext, CoursesActivity::class.java)
//                            startActivity(intent)
//                        }
//                        else{
//                            Toast.makeText(baseContext,response.errorBody()!!.toString(),Toast.LENGTH_LONG).show()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                   Toast.makeText(baseContext,"Your login request cannot be completed at this time,Pleas try again later",Toast.LENGTH_LONG).show()
//                    }
//
//                })
            }

        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, { loginResponse ->
            binding.pbLoading2.visibility = View.GONE
            if (!loginResponse.password.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG)
                    .show()
            }
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7

        })
        userViewModel.logErrorLiveData.observe(this, { error ->
            binding.pbLoading2.visibility = View.GONE
            Toast.makeText(baseContext, "Login  is unsuccessful", Toast.LENGTH_LONG)
                .show()
        })
    }

}
