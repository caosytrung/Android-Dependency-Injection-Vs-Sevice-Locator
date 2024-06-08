package com.trungcs.simple_service_locator.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.trungcs.simple_service_locator.service_locator.SimpleServiceLocator

class HelloServiceLocatorActivity : ComponentActivity() {

    private var viewModel: HelloServiceLocatorViewModel = SimpleServiceLocator.instance.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                HelloView(viewModel.getHello())
            }
        }
    }

    @Composable
    fun HelloView(hello: String) {
        CenterColumn(modifier = Modifier.fillMaxSize()) {
            Text(hello)
        }
    }

    @Composable
    fun CenterColumn(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit,
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            content()
        }
    }
}
