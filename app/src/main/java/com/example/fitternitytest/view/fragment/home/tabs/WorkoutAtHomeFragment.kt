package com.example.fitternitytest.view.fragment.home.tabs

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.bumptech.glide.RequestManager
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseFragment
import com.example.fitternitytest.base.OnClickHandler
import com.example.fitternitytest.databinding.FragmentWorkoutAtHomeBinding
import com.example.fitternitytest.di.viewmodel.ViewModelProviderFactory
import com.example.fitternitytest.model.Campaigns
import com.example.fitternitytest.model.ProductTags
import com.example.fitternitytest.model.WorkoutAtHomeModel
import com.example.fitternitytest.model.upcoming_classes_home.Data
import com.example.fitternitytest.utils.Status
import com.example.fitternitytest.view.adapter.ChallengeAdapter
import com.example.fitternitytest.view.adapter.UpcomingClassesAdapter
import com.example.fitternitytest.view.fragment.home.HomeFragmentDirections
import com.example.fitternitytest.view.fragment.home.HomeViewModel
import com.synnapps.carouselview.ImageListener
import javax.inject.Inject

class WorkoutAtHomeFragment : BaseFragment<FragmentWorkoutAtHomeBinding>() {

    private val TAG = "WorkoutAtHomeFragment"

    private var count = 0
    @Inject
    lateinit var onClickHandler: OnClickHandler
    @Inject
    lateinit var clickHandler: OnClickHandler

    @Inject
    lateinit var factory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var upcomingClassesAdapter: UpcomingClassesAdapter

    @Inject
    lateinit var challengeAdapter: ChallengeAdapter
    private val viewModel: HomeViewModel by activityViewModels { factory }

    override val layout: Int
        get() = R.layout.fragment_workout_at_home

    private lateinit var binding: FragmentWorkoutAtHomeBinding

    override fun init(bind: FragmentWorkoutAtHomeBinding) {
        binding = bind
        binding.listener = onClickHandler
        binding.recyclerViewUpcomingClasses.adapter = upcomingClassesAdapter
        binding.recyclerViewChallenges.adapter = challengeAdapter
        binding.swipeToRefresh.setOnRefreshListener {
            getData()
        }
        viewModel.observeWorkoutAtHome().removeObservers(viewLifecycleOwner)
        getData()
    }

    private fun getData() {
        viewModel.observeWorkoutAtHome().observe(viewLifecycleOwner, Observer {
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

    private fun setData(data: WorkoutAtHomeModel?) {
        binding.progressbar.visibility = View.GONE
        viewModel.setProductTags(data?.product_tags as ArrayList<ProductTags>)
        setCampaigns(data.campaigns)
        binding.workoutAtHomeModel = data
        upcomingClassesAdapter.setData(data.upcoming_classes.data as ArrayList<Data>)
        challengeAdapter.setData(data.challenge.data as ArrayList<com.example.fitternitytest.model.challenge.Data>)
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
        fun newInstance() = WorkoutAtHomeFragment()
    }


}