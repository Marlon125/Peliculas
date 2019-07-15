package com.marlon.peliculas.infrastructure.core

import com.marlon.peliculas.infrastructure.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)


}