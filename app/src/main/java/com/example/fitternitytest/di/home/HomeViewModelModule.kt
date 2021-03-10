package com.example.fitternitytest.di.home

import androidx.lifecycle.ViewModel
import com.example.fitternitytest.di.viewmodel.ViewModelKey
import com.example.fitternitytest.view.fragment.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

}