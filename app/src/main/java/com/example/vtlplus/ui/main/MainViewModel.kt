package com.example.vtlplus.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class MainViewModel
 : ViewModel() {

   val repository: Repository =  Repository()

    val user: LiveData<User>  = repository.getUser()

}