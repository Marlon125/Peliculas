package com.marlon.peliculas.infrastructure.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.failure
import com.github.kittinunf.result.success
import com.marlon.peliculas.R
import com.marlon.peliculas.infrastructure.core.MovieApplication
import com.marlon.peliculas.infrastructure.utils.debug

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MovieApplication).movieComponent.inject(this)
//        (application as MovieApplication).movieComponent.inject(this)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        setConnection()
    }

    private fun setConnection(){
        Fuel.get("https://api.themoviedb.org/3/movie/550?api_key=e842010883423b76bbe04698fb7eb89e")
            .responseString { _, _, result ->

                result.success {
                    val data = result.get()

                    debug(data)

                }

                result.failure { Toast.makeText(this,"error", Toast.LENGTH_LONG).show() }
            }
    }
}
