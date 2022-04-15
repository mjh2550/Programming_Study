package com.mjh.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mjh.lovetest.R
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() , View.OnClickListener {

    var option = -1
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        option = arguments?.getInt("index") ?: -1 //전체 null 이면 -1 반환

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btn_home.setOnClickListener(this)

        setResult(option)
    }

    private fun setResult(option: Int) {

        when(option){
            1 ->{
                //textview.setText(""); 와 동일
                textView.text ="1"
                textView3.text = "1"
            }
            2 ->{
                textView.text ="2"
                textView3.text = "2"

            }
            3 ->{

                textView.text ="3"
                textView3.text = "3"
            }
            4 ->{

                textView.text ="4"
                textView3.text = "4"
            }
            5 ->{
                textView.text ="5"
                textView3.text = "5"
            }


        }

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btn_home -> navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }


    }
}