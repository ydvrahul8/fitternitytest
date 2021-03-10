package com.example.fitternitytest.di.home

import com.example.fitternitytest.base.OnClickHandler
import com.example.fitternitytest.view.adapter.*
import dagger.Module
import dagger.Provides

@Module
object HomeModule {

    @HomeScope
    @Provides
    @JvmStatic
    fun provideProductAdapter(): ProductAdapter {
        return ProductAdapter()
    }


    @HomeScope
    @Provides
    @JvmStatic
    fun provideCategoryTagAdapter(onClickHandler: OnClickHandler): CategoryTagAdapter {
        return CategoryTagAdapter(onClickHandler)
    }

    @HomeScope
    @Provides
    @JvmStatic
    fun provideUpcomingClassesAdapter(): UpcomingClassesAdapter {
        return UpcomingClassesAdapter()
    }

    @HomeScope
    @Provides
    @JvmStatic
    fun provideFitnessCentreAdapter(): FitnessCenterAdapter {
        return FitnessCenterAdapter()
    }


   @HomeScope
    @Provides
    @JvmStatic
    fun provideChallengeAdapter(): ChallengeAdapter {
        return ChallengeAdapter()
    }

}