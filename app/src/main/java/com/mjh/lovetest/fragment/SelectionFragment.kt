package com.mjh.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mjh.lovetest.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btn_back.setOnClickListener(this)
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)
        option_5.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){ //view가  null이아니면 해당 로직 타고 null이면 null 반환
            //fragment는 이동시 스택 쌓이므로 뒤로가기는 pop시키면된다.
            R.id.btn_back -> navController.popBackStack()
//          R.id.option_1 -> navController.navigate(R.id.action_selectionFragment_to_resultFragment,bundle) //이거랑 같음
            R.id.option_1 -> navigateWithIndex(1) //데이터 보내는 함수 호출
            R.id.option_2 -> navigateWithIndex(2)
            R.id.option_3 -> navigateWithIndex(3)
            R.id.option_4 -> navigateWithIndex(4)
            R.id.option_5 -> navigateWithIndex(5)

        }

    }
    //bundle로 데이터 보내는 함수
    fun navigateWithIndex(index : Int){
        //{key: value} 담기
        val bundle = bundleOf("index" to index)
        //데이터 보냄
        navController.navigate(R.id.action_selectionFragment_to_resultFragment,bundle)
    }
}