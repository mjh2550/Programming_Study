package com.mjh.rxexam.compose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.mjh.rxexam.compose.ui.theme.RxExamTheme
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

@AndroidEntryPoint
class JcMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           RxExamTheme {
               /**
                * Compose + Hilt + VM 프로세스 이해를 위한 예제 작성
                *
                */

                testComposable(str = "test3333")
            }
        }
    }
}

@Composable
fun testComposable(str:String,viewModel: JcViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){

    val context = LocalContext.current

    //view의 변수
    val viewData = remember { mutableStateOf("")}

    //값이 전달되는 파이프라인
    val subject : Subject<String> = PublishSubject.create()

    //binding
    subject.subscribeBy { viewData.value = it }

    Column() {
        TextField(value = viewData.value, onValueChange =
        { Log.d("test","onChanged : $it")
            subject.onNext(it) })

        Text(text = viewData.value)
    }

    /**
     * State 패턴
     * State를 선언한 후 메서드를 통해 Handle한다.
     * 기본적으로 Readable(읽기전용) 이며, MutableState를 선언해서 변경한다.
     */

    /*val _s1 = remember { mutableStateOf(str)}
    val s1 : State<String> =_s1

    TextField(value = s1.value, onValueChange =
    { Log.d("test","onChanged : $it")
       _s1.value=it })
    val testVal = viewModel.printTest()*/

//    TextField(value =testVal, onValueChange ={Log.d("onChange","change : $it")} )


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RxExamTheme {
//        Greeting("Android")
        testComposable(str = "이곳은 텍스트 필드 입니다.")
    }
}