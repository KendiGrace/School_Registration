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
    lateinit var binding:ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
    lateinit var sharedPrefs: SharedPreferences
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
//        pbLoading=findViewById(R.id.pbLoading)
//        tvTitle=findViewById(R.id.tvTitle)
//        etName=findViewById(R.id.etName)
//        etDob=findViewById(R.id.etDob)
//        etPhone=findViewById(R.id.etPhone)
//        etEmail=findViewById(R.id.etEmail)
//        etPassword=findViewById(R.id.etPassword)
//        btnRegister=findViewById(R.id.btnRegister)
//        spNationality=findViewById(R.id.spNationality)

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
        binding.spNationality.adapter=nationalitiesAdapter

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



