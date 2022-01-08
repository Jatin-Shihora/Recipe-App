package com.example.reciepe_app_kt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint //mark this component to be setup for di with Hilt/Dagger
class MainActivity : AppCompatActivity() {

    private val TAG : String = "AppDebug"

    @Inject
    lateinit var app:BaseApplication

    @Inject //This is field injection //field injection because constructor injection doesn't work on activities
    lateinit var someRandomString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate:${someRandomString}")
        Log.d(TAG, "onCreate:${app}")
    }
}

