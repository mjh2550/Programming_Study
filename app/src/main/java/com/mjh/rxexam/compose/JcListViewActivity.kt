package com.mjh.rxexam.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mjh.rxexam.compose.ui.theme.RxExamTheme

class JcListViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           jcListView()
        }
    }
}

@Composable
fun jcListView(){
    RxExamTheme {
        //LazyColumn은 화면에 보여지는 컴포저블만을 표시하는 scrollable한 column
        LazyColumn(){
            //한개씩 표현할 땐 item, 여러개 반복은 items , custom은 itemsIndex
            /*item {
                jcCard(order = 0)
                jcCard(order = 1)
            }*/
            /*items(2000){
                jcCard(order = it) //index 는 it
            }*/
            itemsIndexed(
                listOf(100,200,300) //아이템 여러개생성
            ){ index, item ->
                jcCard(order = item) //아이템 기반으로 컴포저블 생성
                jcCard(order = index) //아이템 기반으로 컴포저블 생성
            }
        }
    }
}

@Composable
private fun jcCard(order :Int) {
    Card(
        Modifier
            .padding(12.dp)
            .border(width = 4.dp, color = Color.Black)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Greeting2("Android $order")
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Helloooooo $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    jcListView()
}