package com.example.reciepe_app_kt.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reciepe_app_kt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //mark this component to be setup for di with Hilt/Dagger
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

