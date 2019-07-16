package com.marlon.peliculas.infrastructure.core

import android.app.Application
import android.content.Context
import com.marlon.peliculas.application.coordinator.MovieCoordinator
import com.marlon.peliculas.infrastructure.implementation.ImpMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideMovieCoordinator(): MovieCoordinator {
        val movieRepository = ImpMovieRepository(application)
        return MovieCoordinator(movieRepository)
    }


}