package com.example.catchok_apps.base

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.catchok_apps.firebase.Goal
import com.example.catchok_apps.firebase.Level
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor():ViewModel() {
    lateinit var name:String
    lateinit var lastname:String
    var age:Int? = null
    var weight: Int? = null
    var height:Int? = null
    var goalWeight:Int? = null
    var goal:Goal = Goal.GAIN_MUSCLES
    var level:Level = Level.INTERMEDIATE
    lateinit var bio:String

}