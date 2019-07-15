package com.marlon.peliculas.infrastructure.core

import android.app.Application

class MovieApplication : Application() {

    lateinit var movieComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        movieComponent = initDagger(this)
    }

    private fun initDagger(app: MovieApplication): ApplicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(app))
            .build()
}