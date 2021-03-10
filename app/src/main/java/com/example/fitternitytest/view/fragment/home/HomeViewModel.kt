package com.example.fitternitytest.view.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.fitternitytest.model.ProductTags
import com.example.fitternitytest.network.APIRequests
import com.example.fitternitytest.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val apiRequests: APIRequests) : ViewModel() {

    fun observeWorkoutAtHome() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiRequests.getWorkoutAtHome()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = "Something went wrong"))
        }
    }

    fun observeWorkoutInStudio() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiRequests.getWorkoutAtStudio()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = "Something went wrong"))
        }
    }

    private val _productTags = MutableLiveData<ArrayList<ProductTags>>()
    val productTags: LiveData<ArrayList<ProductTags>> get() = _productTags

    fun setProductTags(productTags: ArrayList<ProductTags>) {
        _productTags.value = productTags
    }

}