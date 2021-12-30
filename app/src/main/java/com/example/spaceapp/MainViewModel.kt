package com.example.spaceapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapp.apiFetch.DTO.UpcomingEvents
import com.example.spaceapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<UpcomingEvents>> = MutableLiveData()

    fun getUpcomingEvents() {
        viewModelScope.launch {
            val response = repository.getEvents()
            myResponse.value = response
        }
    }
}