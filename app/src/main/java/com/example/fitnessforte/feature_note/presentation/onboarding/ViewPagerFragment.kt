package com.example.fitnessforte.feature_note.presentation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.fitnessforte.R
import com.example.fitnessforte.feature_note.presentation.onboarding.screen.GettingStarted
import com.example.fitnessforte.feature_note.presentation.onboarding.screen.HeightWeight


class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_view_pager, container, false)
        val fragList = arrayListOf<Fragment>(
            GettingStarted(),
            HeightWeight()
        )
        val adapter = ViewPagerAdapter(
            fragList,
            requireActivity().supportFragmentManager,
            lifecycle
        )


        val view2 = view.findViewById<ViewPager2>(R.id.onBoardingViewPager)

        view2.adapter = adapter


        return view
    }

}