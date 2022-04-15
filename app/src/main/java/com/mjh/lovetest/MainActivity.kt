package com.mjh.lovetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    lateinit var navController: NavController
    lateinit var navHostFragment :NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //네비게이션 바인딩
//        var fragmentContainerView : FragmentContainerView  = findViewById(R.id.nav_host_fragment)
//        navController = nav_host_fragment.findNavController()

        /**
         * 기본적으로 "as" 연산자는 대상 값을 as로 지정한 타입으로 캐스트 하며, 해당 타입으로 바꿀 수 없으면 ClassCastException이 발생하게 됩니다.
        이럴 경우 is 연산자를 통해 대상 값이 해당 타입으로 변환 가능한 타입인지 체크해야 하지만 코틀린에서는 훨씬 더 간결한 기능으로 "as?" 연산자를 제공합니다.
        "as?" 연산자는 어떤 값을 지정한 타입으로 캐스트를 하고, 만약 대상 타입으로 캐스트 할 수 없으면 null을 반환하게 됩니다.
         */

        /**
         * 우리는 FragmentContainerView를 사용하여 NavHostFragment를 만들었다.
        위와 같이 supportFragmentManager에서 findFragmentById를 사용해 직접 해당 FragmentContainerView를 검색해서
        해당 View가 지닌 Class속성인 navHostFragment로 TypeCasting을 해야 가져올 수 있다.
         */
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        var navController = navHostFragment.navController
//        navController = nav_host_fragment.findNavController()
        navController = navHostFragment.findNavController()



    }
}