package com.example.fitternitytest.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitternitytest.view.fragment.home.tabs.WorkoutAtHomeFragment
import com.example.fitternitytest.view.fragment.home.tabs.WorkoutInStudioFragment

class ViewPagerFragmentAdapter(
    fragmentActivity: FragmentActivity
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WorkoutInStudioFragment.newInstance()
            1 -> WorkoutAtHomeFragment.newInstance()
            else -> throw Exception("Array out of bound")
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}