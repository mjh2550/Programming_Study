package com.mjh.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mjh.lovetest.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment(), View.OnClickListener {
    //onAttach -> onCreate -> onCreateView -> onViewCreated -> onActivityCreated

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        //현재클래스 인터페이스를 사용
        btn_next.setOnClickListener(this)
//        btn_next.setOnClickListener {
//            navController.navigate(R.id.action_questionFragment_to_selectionFragment)
//        }

    }

    override fun onClick(v: View?) {
//        if(p0?.id==R.id.btn_next)  navController.navigate(R.id.action_questionFragment_to_selectionFragment)

        when(v?.id){
            //btn_next 클릭시
            R.id.btn_next -> {
                navController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }

        }
    }
}