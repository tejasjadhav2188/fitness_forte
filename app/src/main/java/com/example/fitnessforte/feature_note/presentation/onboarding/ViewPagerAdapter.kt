package com.example.fitnessforte.feature_note.presentation.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragList : ArrayList<Fragment>,
    fragmentManager: FragmentManager,
    lifeCycle:Lifecycle
): FragmentStateAdapter(fragmentManager,lifeCycle) {
    private val fragmentList = fragList
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}