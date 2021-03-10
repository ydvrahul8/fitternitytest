package com.example.fitternitytest.view.fragment.home.tabs

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.bumptech.glide.RequestManager
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseFragment
import com.example.fitternitytest.base.OnClickHandler
import com.example.fitternitytest.databinding.FragmentWorkoutInStudioBinding
import com.example.fitternitytest.di.viewmodel.ViewModelProviderFactory
import com.example.fitternitytest.model.Campaigns
import com.example.fitternitytest.model.ProductTags
import com.example.fitternitytest.model.WorkoutAtWork
import com.example.fitternitytest.model.categories.Categorytag
import com.example.fitternitytest.model.upcoming_classes_home.Data
import com.example.fitternitytest.utils.Status
import com.example.fitternitytest.view.adapter.CategoryTagAdapter
import com.example.fitternitytest.view.adapter.FitnessCenterAdapter
import com.example.fitternitytest.view.adapter.UpcomingClassesAdapter
import com.example.fitternitytest.view.fragment.home.HomeFragmentDirections
import com.example.fitternitytest.view.fragment.home.HomeViewModel
import com.synnapps.carouselview.ImageListener
import javax.inject.Inject


class WorkoutInStudioFragment : BaseFragment<FragmentWorkoutInStudioBinding>() {

    private val TAG = "WorkoutInStudioFragment"

    @Inject
    lateinit var onClickHandler: OnClickHandler

    @Inject
    lateinit var factory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var categoryTagAdapter: CategoryTagAdapter

    @Inject
    lateinit var upcomingClassesAdapter: UpcomingClassesAdapter

    @Inject
    lateinit var fitnessCenterAdapter: FitnessCenterAdapter

    private val viewModel: HomeViewModel by activityViewModels { factory }

    override val layout: Int
        get() = R.layout.fragment_workout_in_studio

    private lateinit var binding: FragmentWorkoutInStudioBinding

    override fun init(bind: FragmentWorkoutInStudioBinding) {
        binding = bind
        binding.listener = onClickHandler
        binding.recyclerViewDiscover.adapter = categoryTagAdapter
        binding.recyclerViewUpcomingClasses.adapter = upcomingClassesAdapter
        binding.recyclerViewFitnessCentre.adapter = fitnessCenterAdapter
        viewModel.observeWorkoutInStudio().removeObservers(viewLifecycleOwner)
        binding.swipeToRefresh.setOnRefreshListener {
            getData()
        }
        getData()
    }

    private fun getData() {
        viewModel.observeWorkoutInStudio().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                if(binding.swipeToRefresh.isRefreshing)
                    binding.swipeToRefresh.isRefreshing = false
                when (it.status) {
                    Status.LOADING -> binding.progressbar.visibility = View.VISIBLE
                    Status.SUCCESS -> setData(it.data)
                    Status.ERROR -> {
                        binding.progressbar.visibility = View.VISIBLE
                        binding.errorMessage.text = it.message
                    }
                }
            }
        })
    }


    private fun setData(data: WorkoutAtWork?) {
        binding.workoutInStudio =data
        binding.progressbar.visibility = View.GONE
        viewModel.setProductTags(data?.product_tags as ArrayList<ProductTags>)
        setCampaigns(data.campaigns)
        categoryTagAdapter.setData(data.categories.categorytags as ArrayList<Categorytag>)
        upcomingClassesAdapter.setData(data.upcoming_classes.data as ArrayList<Data>)
        fitnessCenterAdapter.setData(data.fitness_centres.data as ArrayList<com.example.fitternitytest.model.fitness_centre.Data>)
    }

    private fun setCampaigns(campaigns: List<Campaigns>) {
        val imageListener = ImageListener { position, imageView ->
            if (imageView != null) {
                requestManager.load(campaigns[position].image).into(imageView)
            }
        }
        binding.carouselView.setImageListener(imageListener)
        binding.carouselView.setImageClickListener {
            val data = HomeFragmentDirections.actionHomeFragmentToFitternityFragment()
            view?.findNavController()?.navigate(data)
        }
        binding.carouselView.pageCount = campaigns.size
    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkoutInStudioFragment()
    }


}