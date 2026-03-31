package com.example.bookinf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookinf.SDUI.VMod
import com.example.bookinf.ui.SDUIContentScreen
import com.example.bookinf.ui.theme.BookinfTheme
import com.example.bookinf.ui.theme.size.AppSpacings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookinfTheme {
                val viewModel: VMod = viewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SDUIContentScreen(
                        uiData = viewModel.data,
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = AppSpacings.ScreenMargin)
                    )
                }
            }
        }
    }
}
