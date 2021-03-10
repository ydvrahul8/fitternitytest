package com.example.fitternitytest.view.fragment.home

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseFragment
import com.example.fitternitytest.base.OnClickHandler
import com.example.fitternitytest.databinding.FragmentHomeBinding
import com.example.fitternitytest.di.viewmodel.ViewModelProviderFactory
import com.example.fitternitytest.view.adapter.ProductAdapter
import com.example.fitternitytest.view.adapter.UpcomingClassesAdapter
import com.example.fitternitytest.view.adapter.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val TAG = "HomeFragment"

    @Inject
    lateinit var clickHandler: OnClickHandler

    @Inject
    lateinit var factory: ViewModelProviderFactory

    @Inject
    lateinit var adapter: ProductAdapter

    private val args: HomeFragmentArgs by navArgs()

    override val layout: Int
        get() = R.layout.fragment_home

    private val titles =
        arrayOf("Workout In Studio", "Workout At Home")

    private val viewModel: HomeViewModel by activityViewModels { factory }

    override fun init(bind: FragmentHomeBinding) {
        val location = args.location
        textView_Location.text = location.location
        bind.listener = clickHandler
        bind.recyclerViewProductTags.adapter = adapter
        setTabs(bind)
        setProductTagsObserver()
    }

    private fun setProductTagsObserver() {
        viewModel.productTags.removeObservers(viewLifecycleOwner)
        viewModel.productTags.observe(viewLifecycleOwner, Observer {
            if (it != null)
                adapter.setData(it)
        })
    }

    private fun setTabs(binding: FragmentHomeBinding) {
        binding.viewPager.adapter = ViewPagerFragmentAdapter(requireActivity())
        TabLayoutMediator(binding.tabs, binding.viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
                tab.text = titles[position]
            }
        ).attach()
    }
}