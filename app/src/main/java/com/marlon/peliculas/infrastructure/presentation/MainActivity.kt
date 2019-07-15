package com.marlon.peliculas.infrastructure.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marlon.peliculas.R
import com.marlon.peliculas.infrastructure.core.MovieApplication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MovieApplication).movieComponent.inject(this)
        setContentView(R.layout.activity_main)
    }
}
