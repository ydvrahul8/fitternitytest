package com.example.fitternitytest.di

import com.example.fitternitytest.di.home.HomeModule
import com.example.fitternitytest.di.home.HomeScope
import com.example.fitternitytest.di.home.HomeViewModelModule
import com.example.fitternitytest.di.location.LocationModule
import com.example.fitternitytest.di.location.LocationScope
import com.example.fitternitytest.view.fragment.fitternity_page.FitternityFragment
import com.example.fitternitytest.view.fragment.home.HomeFragment
import com.example.fitternitytest.view.fragment.home.tabs.WorkoutAtHomeFragment
import com.example.fitternitytest.view.fragment.home.tabs.WorkoutInStudioFragment
import com.example.fitternitytest.view.fragment.location.LocationFragment
import com.example.fitternitytest.view.fragment.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilderModule {
    @ContributesAndroidInjector
    fun contributeSplashFragment(): SplashFragment

    @HomeScope
    @ContributesAndroidInjector(
        modules = [
            HomeViewModelModule::class,
            HomeModule::class]
    )
    fun contributeHomeFragment(): HomeFragment

    @LocationScope
    @ContributesAndroidInjector(
        modules = [
            LocationModule::class
        ]
    )
    fun contributeLocationFragment(): LocationFragment

    @HomeScope
    @ContributesAndroidInjector(
        modules = [
            HomeViewModelModule::class,
            HomeModule::class]
    )
    fun contributeWorkoutInStudio(): WorkoutInStudioFragment

    @HomeScope
    @ContributesAndroidInjector(
        modules = [
            HomeViewModelModule::class,
            HomeModule::class]
    )
    fun contributeWorkoutAtHomeFragment(): WorkoutAtHomeFragment

    @ContributesAndroidInjector
    fun contributeFitternityFragment(): FitternityFragment

}