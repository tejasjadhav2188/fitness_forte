package com.example.fitnessforte.feature_note.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessforte.R
import com.example.fitnessforte.databinding.ActivityMainBinding
import com.example.fitnessforte.databinding.FragmentMainScreenBinding


class MainScreen : Fragment() {

    private var _binding : FragmentMainScreenBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding =  FragmentMainScreenBinding.inflate(inflater,container,false)

        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val height = sharedPref.getInt("Height",0)
        val weight = sharedPref.getInt("Weight",0)
        val text = "Height : $height and Weight : $weight"
        binding.msText.text = text


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}