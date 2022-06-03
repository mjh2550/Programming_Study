package com.mjh.jcexample

import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mjh.jcexample.ui.theme.JCExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Hello")},
            backgroundColor = Color(0xfff25287))
    }
    ) {
//        Text(text = "Hello $name!")
        MyComposableView()
    }
}
@Composable
fun MyRowItem(){
    //호리젠탈 리니어
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0x0ffeaffd0)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "안녕하세요?",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요?")
        Text(text = "안녕하세요?")
    }
}


@Composable
fun MyComposableView(){
    Log.d("TAG","MyComposableView")

    //버티컬리니어
    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState()) //스크롤
            .fillMaxWidth() //너비 풀 사이즈
    ) {
        for (i in 0..20) {
            MyRowItem()
        }
    }
}



@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    JCExampleTheme {
        Greeting("Android")
    }
}