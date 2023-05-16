package com.example.fitnessforte.feature_note.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessforte.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FitnessForte)
        setContentView(R.layout.activity_main)

    }
}