package com.mjh.jcexample.basic

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mjh.jcexample.MyComposableView
import com.mjh.jcexample.R
import com.mjh.jcexample.basic.ui.theme.JCExampleTheme

class MainLazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    SetTopBar(name2 = "리스트입니다.")
                    ContentView()
                }
            }
        }
    }
}
@Composable
fun ContentView(){
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            backgroundColor = Color.White,
            topBar = { SetTopBar(name2 = "리스트입니다.") }
        ) {


        }

        
    }

}


@Composable
fun SetTopBar(name2 : String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name2) },
                backgroundColor = MaterialTheme.colors.primarySurface
            )
        }
    ) {

        //메모리 관리가 들어간 LazyColumn
       /* LazyColumn(){
            //1개
            item {
                Text(text = "First Item")
            }

            //여러항목
            items (5){ i ->
                Text(text = "Item: $i")
            }

        }*/
        MessageList(messages = ListClass.list)
    }
}
@Composable
fun MessageList(messages: List<String>){
    LazyColumn{
        items(messages){m ->
                MessageRow(m)
        }
    }
}

@Composable
fun MessageRow(m: String) {
    Row() {
        Text("$m")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JCExampleTheme {
//        Greeting2("Android")
//        SetTopBar(name2 = "리스트입니다.")
        ContentView()
    }
}