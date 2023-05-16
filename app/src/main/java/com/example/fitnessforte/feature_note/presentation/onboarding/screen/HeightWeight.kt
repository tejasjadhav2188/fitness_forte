package com.example.fitnessforte.feature_note.presentation.onboarding.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.fitnessforte.R

class HeightWeight : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_height_weight, container, false)
        val weightPicker : NumberPicker? = view?.findViewById<NumberPicker?>(R.id.hw_weightPicker)
            .also {
            it?.minValue = 20
            it?.maxValue = 250
        }

        val heightPicker : NumberPicker? = view?.findViewById<NumberPicker?>(R.id.hw_heightPicker).also{
            it?.minValue=60
            it?.maxValue=250
        }

        weightPicker?.setOnValueChangedListener { _, _, _ ->
            if (heightPicker != null) {
                val bmi = calculateBMI(heightPicker.value,weightPicker.value)
                view?.findViewById<TextView>(R.id.hw_bmi).also{
                    it?.text = String.format("Your BMI is : %.2f",bmi)
                }
            }
        }



        heightPicker?.setOnValueChangedListener { _, _, _ ->
            if (weightPicker != null) {
                val bmi = calculateBMI(heightPicker.value, weightPicker.value )
                view?.findViewById<TextView>(R.id.hw_bmi).also{
                    it?.text = String.format("Your BMI is : %.2f",bmi)
                }
            }
        }

        val finishbtn = view.findViewById<Button>(R.id.hw_btnfinish).also{
            it.setOnClickListener{
                findNavController().navigate(R.id.action_viewPagerFragment_to_splashScreen2)
                onBoardingFinished(heightPicker!!.value,weightPicker!!.value)
            }
        }

        return view
    }

    private fun calculateBMI(height : Int, weight : Int) : Double {
        val height = height.toDouble()/100
        val BMI = weight.toDouble() / (height * height)
        return BMI


    }

    private fun onBoardingFinished(height:Int,weight:Int){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.putInt("Height",height)
        editor.putInt("Weight",weight)
        editor.apply()
    }


}