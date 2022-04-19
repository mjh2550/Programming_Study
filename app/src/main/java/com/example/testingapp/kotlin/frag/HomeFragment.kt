package com.example.testingapp.kotlin.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.testingapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() ,View.OnClickListener{

    private lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btn_01.setOnClickListener(this)
        btn_02.setOnClickListener(this)
        btn_03.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_01 -> {
                val num = bundleOf("num" to 1)
                navController.navigate(R.id.action_homeFragment_to_infoFragment, num)
            }
            R.id.btn_02 -> {
                val num = bundleOf("num" to 2)
                navController.navigate(R.id.action_homeFragment_to_resultFragment, num)
            }
            R.id.btn_03 -> {
                val num = bundleOf("num" to 3)
                navController.navigate(R.id.action_homeFragment_to_settingFragment3, num)
            }
        }

    }

//    private fun navigateWithIndex(Index : Int) {
//        val bundle = bundleOf("Index" to Index)
//
//        navController.navigate(R.id.action_homeFragment_to_infoFragment,bundle)
//
//    }
}