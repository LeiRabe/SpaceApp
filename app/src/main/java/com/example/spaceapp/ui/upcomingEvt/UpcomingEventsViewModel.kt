package com.example.spaceapp.ui.upcomingEvt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UpcomingEventsViewModel {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Upcoming Events fragment"
    }
    val text: LiveData<String> = _text
}