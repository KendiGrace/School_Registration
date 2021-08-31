        var coursesList = listOf(
            Course(
                "Front-end Development",
                "JavaScript for building websites",
                "FrontEnd101",
                "Purity Maina"
            ),
            Course("IOT", "Internet of Things", "IOT101", "Barre Yasin"),
            Course(
                "Mobile Development",
                "Introduction to Android Development",
                "android101",
                "John Owuor"
            ),
            Course("Back-end Development", "Server-side using Python", "Python101", "James Mwai"),
            Course("Start-up ", "Entrepreneurship", "Start-up101", "Kelly Gatwiri"),
            Course("UX Development", "HTML,CSS", "Developer101", "Wendy Orengo"),
            Course("UI/UX Design", "Human-centered Design", "Design01", "Eric Asiago"),
            Course("UX Research", "Design Thinking Process", "Research101", "Joy Taracha")
        )
        rvCourse=findViewById(R.id.rvCourses)
        var coursesAdapter=CoursesrvAdapter(coursesList,baseContext)
        rvCourse.apply {
            layoutManager=LinearLayoutManager(baseContext)
            rvCourse.adapter=coursesAdapter
        }

    fun castViews(){
        etEmail2=findViewById(R.id.etEmail2)
        etPass2=findViewById(R.id.etPass2)
        btnLogin=findViewById(R.id.btnLogin)
        pbLoading2=findViewById(R.id.pbLoading)
    }

                val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
                val request = retrofit.studentLogin(logRequest)
                request.enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        pbLoading2.visibility=View.GONE
                        if(response.isSuccessful){
                            Toast.makeText(baseContext,"Login request successful",Toast.LENGTH_SHORT).show()
                            var intent = Intent(baseContext, CoursesActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(baseContext,response.errorBody()!!.toString(),Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                   Toast.makeText(baseContext,"Your login request cannot be completed at this time,Pleas try again later",Toast.LENGTH_LONG).show()
                    }

                })

lateinit var etEmail2:EditText lateinit var etPass2:EditText lateinit var btnLogin:Button lateinit
var pbLoading2:ProgressBar

// // var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
// var request = retrofit.registerStudent(regRequest)
// request.enqueue(object : Callback<RegistrationResponse> { // override fun onResponse(call:
Call<RegistrationResponse>, response: Response<RegistrationResponse>) { // pbLoading.visibility =
View.GONE // if (response.isSuccessful) { // Toast.makeText(baseContext, "Your registration is
Successful", Toast.LENGTH_SHORT).show()

// } else { // Toast.makeText(baseContext, response.errorBody()?.toString(), Toast.LENGTH_SHORT)
.show()
// } // // } // // override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) { //
Toast.makeText(baseContext, "Your Registration request can not be completed at this time,please try
again later", Toast.LENGTH_LONG).show()
// pbLoading.visibility = View.GONE // // } // // })
} // pbLoading=findViewById(R.id.pbLoading)
// tvTitle=findViewById(R.id.tvTitle)
// etName=findViewById(R.id.etName)
// etDob=findViewById(R.id.etDob)
// etPhone=findViewById(R.id.etPhone)
// etEmail=findViewById(R.id.etEmail)
// etPassword=findViewById(R.id.etPassword)
// btnRegister=findViewById(R.id.btnRegister)
// spNationality=findViewById(R.id.spNationality)
// lateinit var tvTitle:TextView // lateinit var etName:EditText // lateinit var etPhone:EditText //
lateinit var etDob:EditText // lateinit var etEmail:EditText // lateinit var etPassword:EditText //
lateinit var spNationality:Spinner // lateinit var btnRegister:Button // lateinit var pbLoading:
ProgressBar
