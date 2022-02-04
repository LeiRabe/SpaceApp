package com.example.spaceapp.retrofit

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.retrofit.model.LaunchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Launch {

    private val url = "https://ll.thespacedevs.com/2.2.0/launch/"

    fun displayAllLaunches(){
        //retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        //service
        val service = retrofit.create(LaunchService::class.java)

        val launchRequest = service.listUpcomingLaunches()

        launchRequest.enqueue(object: Callback<List<LaunchResult>> {
            override fun onResponse(call: Call<List<LaunchResult>>, response: Response<List<LaunchResult>>){
                val allLaunchesResult = response.body()
                if (allLaunchesResult != null){
                    for(c in allLaunchesResult)
                        Log.d("ALL LAUNCHES FROM API","one launch: ${c.id} : ${c.name}")
                }
            }

            override fun onFailure(call: Call<List<LaunchResult>>, t: Throwable) {
                Log.e("CAN'T RETRIEVE DATA",t.toString())
            }
        })
    }

}