package com.example.s1121119

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.s1121119.ui.theme.S1121119Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1121119Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xff95fe95))
                ) { innerPadding ->
                    GameScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    val gameTime = remember { mutableStateOf(0) }
    val score = remember { mutableStateOf(0) }

    val onEndButtonClick = {

    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xff95fe95)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "2024期末上機考(資管二A劉伊宸)",
            fontSize = 18.sp,
            color = Color.Black
        )
        Image(
            painter = painterResource(id = R.drawable.class_a),
            contentDescription = "class_a",
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Text(
            text = "遊戲持續時間: ${gameTime.value} 秒",
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = "您的成績: ${score.value} 分",
            fontSize = 20.sp,
            color = Color.Black
        )

        Button(
            onClick = onEndButtonClick,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text(text = "結束App")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    S1121119Theme {
        GameScreen()
    }
}
