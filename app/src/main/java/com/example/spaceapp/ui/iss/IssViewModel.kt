package com.example.spaceapp.ui.iss

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IssViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is iss Fragment"
    }
    val text: LiveData<String> = _text
}