package com.example.codehiveregistration.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
import com.example.codehiveregistration.R
import com.example.codehiveregistration.ViewModels.UserViewModel
import com.example.codehiveregistration.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()
//    lateinit var tvTitle:TextView
//    lateinit var etName:EditText
//    lateinit var etPhone:EditText
//    lateinit var etDob:EditText
//    lateinit var etEmail:EditText
//    lateinit var etPassword:EditText
//    lateinit var spNationality:Spinner
//    lateinit var btnRegister:Button
//    lateinit var pbLoading:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
    }
    fun castViews(){
//        pbLoading=findViewById(R.id.pbLoading)
//        tvTitle=findViewById(R.id.tvTitle)
//        etName=findViewById(R.id.etName)
//        etDob=findViewById(R.id.etDob)
//        etPhone=findViewById(R.id.etPhone)
//        etEmail=findViewById(R.id.etEmail)
//        etPassword=findViewById(R.id.etPassword)
//        btnRegister=findViewById(R.id.btnRegister)
//        spNationality=findViewById(R.id.spNationality)

        var nationalities= arrayOf("Kenyan","Tanzania","Uganda","Rwanda","Sudan","S.Sudan","Nigeria")
        var nationalitiesAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_dropdown_item,nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spNationality.adapter=nationalitiesAdapter

        clickButtons()


    }
    fun clickButtons() {
        binding.btnRegister.setOnClickListener {
            var error = false
            var name = binding.etName.text.toString()
            if (name.isEmpty()) {
                error == true
                binding.etName.setError("Name is required")
            }
            var nationality = ""
            var phone = binding.etPhone.text.toString()
            if (phone.isEmpty()) {
                error == true
                binding.etPhone.setError("Phonenumber is required")
            }
            var email = binding.etEmail.text.toString()
            if (email.isEmpty()) {
                error == true
                binding.etEmail.setError("Email is required")
            }
            var DOB = binding.etDob.text.toString()
            if (DOB.isEmpty()) {
                error == true
                binding.etDob.setError("Date of Birth is required")
            }
            var password = binding.etPassword.text.toString()
            if (password.isEmpty()) {
                error == true
                binding.etPassword.setError("Password is required")
            } else {
                var regRequest = RegistrationRequest(
                    name = name, nationality = nationality, email = email, Dob = DOB, phone = phone,
                    password = password
                )
                userViewModel.registerStudent(regRequest)
                val intent = Intent(baseContext, LoginActivity::class.java)
                startActivity(intent)
//
//                var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//                var request = retrofit.registerStudent(regRequest)
//                request.enqueue(object : Callback<RegistrationResponse> {
//                    override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
//                        pbLoading.visibility = View.GONE
//                        if (response.isSuccessful) {
//                            Toast.makeText(baseContext, "Your registration is Successful", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(baseContext, response.errorBody()?.toString(), Toast.LENGTH_SHORT).show()
//                        }
//
//                    }
//
//                    override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
//                        Toast.makeText(baseContext, "Your Registration request can not be completed at this time,please try again later", Toast.LENGTH_LONG).show()
//                        pbLoading.visibility = View.GONE
//
//                    }
//
//                })
            }
        }
    }



            override fun onResume() {
                super.onResume()
                userViewModel.registrationResponseLiveData.observe(this, { RegistrationResponse ->
                    binding.pbLoading.visibility = View.GONE
                    if (!RegistrationResponse.password.isNullOrEmpty()) {
                        Toast.makeText(baseContext, "RegistrationSuccessful", Toast.LENGTH_LONG)
                            .show()
                    }

                })
                userViewModel.regErrorLiveData.observe(this, { error ->
                    binding.pbLoading.visibility = View.GONE
                    Toast.makeText(baseContext, "Registration is unsuccessful", Toast.LENGTH_LONG)
                        .show()
                })
            }
        }



