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