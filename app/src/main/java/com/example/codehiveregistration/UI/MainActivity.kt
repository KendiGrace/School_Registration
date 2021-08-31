package com.example.codehiveregistration.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.codehiveregistration.Models.Constants
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.ViewModels.UserViewModel
import com.example.codehiveregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences(Constants.Prefs_File, Context.MODE_PRIVATE)
        castViews()
        RedirectUser()
    }

    fun RedirectUser() {
        var token = sharedPrefs.getString(Constants.Access_Token, Constants.EmptyString)
        if (token!!.isNotEmpty()) {
            var intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)
        }
    }

    fun castViews() {
        var nationalities = arrayOf(
            "choose country",
            "Kenyan",
            "Tanzania",
            "Uganda",
            "Rwanda",
            "Sudan",
            "S.Sudan",
            "Nigeria"
        )
        var nationalitiesAdapter =
            ArrayAdapter(baseContext, android.R.layout.simple_spinner_dropdown_item, nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spNationality.adapter = nationalitiesAdapter

        clickButtons()
    }

    fun clickButtons() {
        binding.btnRegister.setOnClickListener {
            var name = binding.etName.text.toString()
            if (name.isEmpty()) {
                binding.etName.setError("Name is required")
            }
            var nationality = binding.spNationality.selectedItem.toString().uppercase()
            var phone = binding.etPhone.text.toString()
            if (phone.isEmpty()) {
                binding.etPhone.setError("Phonenumber is required")
            }
            var email = binding.etEmail.text.toString()
            if (email.isEmpty()) {
                binding.etEmail.setError("Email is required")
            }
            var DOB = binding.etDob.text.toString()
            if (DOB.isEmpty()) {
                binding.etDob.setError("Date of Birth is required")
            }
            var password = binding.etPassword.text.toString()
            if (password.isEmpty()) {

                binding.etPassword.setError("Password is required")
            } else {
                var regRequest = RegistrationRequest(
                    name = name, nationality = nationality, email = email, Dob = DOB, phone = phone,
                    password = password
                )
                userViewModel.registerStudent(regRequest)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registrationResponseLiveData.observe(this, { RegistrationResponse ->
            binding.pbLoading.visibility = View.GONE
            if (!RegistrationResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(baseContext, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(baseContext, "Not successful", Toast.LENGTH_LONG)
                    .show()
            }

        })
        userViewModel.regErrorLiveData.observe(this, { error ->
            binding.pbLoading.visibility = View.GONE
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()
        })
    }
}


