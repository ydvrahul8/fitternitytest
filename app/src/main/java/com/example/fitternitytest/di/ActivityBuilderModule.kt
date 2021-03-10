package com.example.fitternitytest.di

import com.example.fitternitytest.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {


    @ContributesAndroidInjector(
        modules = [
            FragmentBuilderModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

}