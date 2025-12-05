package com.example.proyectoscaffold

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat.enableEdgeToEdge
import com.example.proyectoscaffold.Ejercicio.Ejercicio01
import com.example.proyectoscaffold.Ejercicio.PantallaProducto
import com.example.proyectoscaffold.Ejercicio.PerfilApp
import com.example.proyectoscaffold.ui.theme.ProyectoScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoScaffoldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    //Ejercicio01()
    //PerfilApp()
    PantallaProducto()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoScaffoldTheme {
        Greeting("Android")
    }
}