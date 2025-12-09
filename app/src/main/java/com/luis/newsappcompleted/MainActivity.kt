package com.luis.newsappcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.luis.newsappcompleted.presentation.onbording.OnBoardingScreen
import com.luis.newsappcompleted.presentation.onbording.OnBoardingViewModel
import com.luis.newsappcompleted.ui.theme.NewsAppCompletedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            NewsAppCompletedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {

                        val viewModel: OnBoardingViewModel = hiltViewModel()
                        OnBoardingScreen(
                            modifier = Modifier.padding(innerPadding),
                            event = viewModel::onEvent,
                            /*event = { event ->
                                viewModel.onEvent(event)
                            }*/
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppCompletedTheme {
        Greeting("Android")
    }
}