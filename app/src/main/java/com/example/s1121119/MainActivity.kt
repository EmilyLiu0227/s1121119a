package com.example.s1121119

import android.app.Activity
import android.content.pm.ActivityInfo
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.s1121119.ui.theme.S1121119Theme
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.ui.geometry.Offset

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1121119Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
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
    val activity = (LocalContext.current as? Activity)

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
            onClick = {
                activity?.finish()
            }
        ) {
            Text(text = "結束App")

            Image(
                painter = painterResource(id = R.drawable.maria2),
                contentDescription = "maria2",
                modifier = Modifier.padding(vertical = 30.dp)
            )

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

@Composable
fun Tap() {
    var msg by remember { mutableStateOf("TAP相關手勢實例") }
    var offset1 by remember { mutableStateOf(Offset.Zero) }
    var offset2 by remember { mutableStateOf(Offset.Zero) }
    var PU = arrayListOf(R.drawable.maria2, R.drawable.maria2,
        R.drawable.maria2, R.drawable.maria2,
        R.drawable.maria2, R.drawable.maria2)
    var Number by remember { mutableStateOf(0) }


    Column {
        Text("\n" + msg)

        Image(
            painter = painterResource(id = PU[Number]),
            contentDescription = "瑪麗亞之美",
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGesturesAfterLongPress(
                        onDrag = { change, dragAmount -> offset2+=dragAmount},
                        onDragStart = {
                            offset1 = it
                            offset2 = it
                                      },
                        onDragEnd = {if (offset2.x >= offset1.x){
                            msg = "長按後向右拖曳"
                            Number ++
                            if (Number>5){Number=0}
                        }
                        else{
                            msg = "長按後向左拖曳"
                            Number --
                            if (Number<0){Number=5}
                        }
                        },

                    )

                }
        )

}
}

