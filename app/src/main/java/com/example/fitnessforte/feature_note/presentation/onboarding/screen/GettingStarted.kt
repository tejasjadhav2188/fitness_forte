package com.example.fitnessforte.feature_note.presentation.onboarding.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.fitnessforte.R

class GettingStarted : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_getting_started, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.onBoardingViewPager)
        if(onBoardingFinished()){
            findNavController().navigate(R.id.action_viewPagerFragment_to_splashScreen2)
        }
        val btn = view.findViewById<Button>(R.id.button).also{
            it.setOnClickListener { viewPager?.currentItem = 1 }

        }
        return view
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

}