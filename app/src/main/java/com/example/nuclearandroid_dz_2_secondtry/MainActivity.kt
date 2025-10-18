package com.example.nuclearandroid_dz_2_secondtry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.nuclearandroid_dz_2_secondtry.ui.theme.NuclearAndroidDZ2SecondTryTheme

import androidx.compose.material3.OutlinedButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NuclearAndroidDZ2SecondTryTheme {
                val backgroundColor = remember { mutableStateOf(Color.White) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(backgroundColor.value),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Greeting(color = backgroundColor.value)
                        ChangeColorButton(onClick = { backgroundColor.value = getRandomColor()},
                            "Сменить цвет")
                        ChangeColorButton(onClick = { backgroundColor.value = Color.White },
                            "Отбелить")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(color: Color, modifier: Modifier = Modifier) {
    Text(
        text = "HEX-код цвета:\n     ${getColorHex(color)}",
        modifier = modifier
    )
}

@Composable
fun ChangeColorButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Text(text)
    }
}

fun getRandomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}

fun getColorHex(color: Color): String {
    val red = (color.red * 255).toInt()
    val green = (color.green * 255).toInt()
    val blue = (color.blue * 255).toInt()

    return String.format("#%02X%02X%02X", red, green, blue)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NuclearAndroidDZ2SecondTryTheme {
        Greeting(color = Color.White)
        ChangeColorButton(onClick = {}, "Сменить цвет")
        ChangeColorButton(onClick = {}, "Отбелить")
    }
}
