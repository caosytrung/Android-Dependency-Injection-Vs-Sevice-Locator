package com.trungcs.diandservicelocator

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trungcs.diandservicelocator.ui.theme.DIAndServiceLocatorTheme
import com.trungcs.simple_dependency_injection.main.HelloDIActivity
import com.trungcs.simple_service_locator.main.ui.HelloServiceLocatorActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DIAndServiceLocatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CenterColumn {
                        ElevatedButton(onClick = ::openDIActivity) {
                            Text(text = stringResource(id = R.string.move_to_di_activity))
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        ElevatedButton(onClick = ::openServiceLocatorActivity) {
                            Text(text = stringResource(id = R.string.move_to_sl_activity))
                        }
                    }
                }
            }
        }
    }

    private fun openDIActivity(){
        startActivity(Intent(this, HelloDIActivity::class.java))
    }

    private fun openServiceLocatorActivity() {
        startActivity(Intent(this, HelloServiceLocatorActivity::class.java))
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DIAndServiceLocatorTheme {

    }
}