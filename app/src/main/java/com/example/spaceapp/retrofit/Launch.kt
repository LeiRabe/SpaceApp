package com.example.spaceapp.retrofit

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.RecyclerAdapter
import com.example.spaceapp.retrofit.model.LaunchHeader
import com.example.spaceapp.retrofit.model.LaunchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Launch {

    private val url = "https://ll.thespacedevs.com"

    private lateinit var results : List<LaunchResult>

    fun displayAllLaunches(recyclerView:RecyclerView, activity: FragmentActivity?){
        //retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        //service
        val service = retrofit.create(LaunchService::class.java)

        val launchRequest = service.listUpcomingLaunches()

        launchRequest.enqueue(object: Callback<LaunchHeader> {
            override fun onResponse(call: Call<LaunchHeader>, response: Response<LaunchHeader>){

                val allLaunchesResult = response.body()

                //button
                if (allLaunchesResult != null) {
                    results = allLaunchesResult.results!!
                }

                Log.d("OnResponse",allLaunchesResult.toString())

                if (allLaunchesResult != null){
                    generateLaunchList(recyclerView, activity, allLaunchesResult.results!!)
                }
            }

            override fun onFailure(call: Call<LaunchHeader>, t: Throwable) {
                Log.e("CAN'T RETRIEVE DATA",t.toString())
            }
        })
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
     fun generateLaunchList(recyclerView:RecyclerView, activity : FragmentActivity? , dataList:List<LaunchResult>) {

        // set the custom adapter to the RecyclerView
        var adapter = RecyclerAdapter(dataList)

        // set a LinearLayoutManager to handle Android
        // RecyclerView behavior
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    fun getResults(): List<LaunchResult> {
        return results
    }

}