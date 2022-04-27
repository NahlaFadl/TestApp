package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainServices : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_services)

        // getting the recyclerview by its id
        val rcy_mainservice =findViewById<RecyclerView>(R.id.rcy_mainService)

        // this creates a vertical layout Manager
        //    rcy_mainservice.layoutManager = LinearLayoutManager(activity)
        rcy_mainservice.apply {
            layoutManager = GridLayoutManager(this@MainServices, 2)
        }


        //   val adapter_mainservice = Adapter_rcy_mainService(data_mainservice)
        val sharedPreferences = getSharedPreferences("userInfo_login", Context.MODE_PRIVATE)
        var call=ApiClient.instance?.getMyApi()
            ?.gitCategory(sharedPreferences.getString("token",null).toString())


        if (call!=null){

            call.enqueue(object : Callback<CategoriesRespon> {
                override fun onResponse(
                    call: Call<CategoriesRespon>?,
                    response: Response<CategoriesRespon>?
                ) {
                    Toast.makeText(this@MainServices,response?.body()?.All_Places_Types.toString(), Toast.LENGTH_LONG).show()



                    var listSize: Int? = response?.body()?.All_Places_Types?.size
                    var placeArray: ArrayList<CategoriesRespon> = ArrayList()

                    for (i in 1..listSize!!) {
                        placeArray.add(response?.body()!!)
                    }
                    val adapter = Adapter_rcy_mainService(placeArray!!)
                    rcy_mainservice.adapter = adapter
                }

                override fun onFailure(call: Call<CategoriesRespon>?, t: Throwable?) {
                    TODO("Not yet implemented")
                }
            })

        }
    }
}