package com.example.happybirthday

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class TutorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialInfo(
                        stringResource(R.string.jetpack_compose_tutorial_text),
                        stringResource(R.string.about_compose_text),
                        stringResource(R.string.info_compose_text),
                        stringResource(R.string.next_screen_text)
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialInfo(title: String, about:String, infoText:String, screen:String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.compose_background)
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image ,
            contentDescription = null
        )
        Text(
            text = title ,
            fontSize = 24.sp ,
            modifier = Modifier
                .padding(16.dp)
                .align(
                    alignment = Alignment.Start
                )
        )
        Text(
            text = about,
            fontSize = TextUnit.Unspecified,
            textAlign = TextAlign.Justify ,
            modifier = Modifier
                .padding (start = 16.dp, end = 16.dp)
        )
        Text(
            text = infoText,
            fontSize = TextUnit.Unspecified,
            textAlign = TextAlign.Justify ,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 68.dp)
        )
        Button(onClick = {
            context.startActivity(Intent(context, TaskActivity::class.java))
        }) {
            Text(
                text = screen,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialPreview() {
    HappyBirthdayTheme {
        TutorialInfo(
            stringResource(R.string.jetpack_compose_tutorial_text),
            stringResource(R.string.about_compose_text),
            stringResource(R.string.info_compose_text),
            stringResource(R.string.next_screen_text)
        )
    }
}