package com.example.fitternitytest.di.location

import com.example.fitternitytest.base.OnClickHandler
import com.example.fitternitytest.view.adapter.LocationAdapter
import dagger.Module
import dagger.Provides

@Module
object LocationModule {

    @LocationScope
    @Provides
    @JvmStatic
    fun provideAdapter(onClickHandler: OnClickHandler): LocationAdapter {
        return LocationAdapter(onClickHandler)
    }

}