package com.example.proyectoscaffold.Ejercicio

import android.util.Log
import androidx.activity.result.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@Composable
fun Ejercicio01() {
    val snackbarHostState = remember { SnackbarHostState() }
    var index by remember { mutableStateOf(2) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Text(
                text = "Configuración",
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 16.dp)
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = index == 1,
                    onClick = {
                        index = 1
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Inicio"
                        )
                    },
                    label = { Text("Inicio") }
                )
                NavigationBarItem(
                    selected = index == 2,
                    onClick = {
                        index = 2
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Configuracion"
                        )
                    },
                    label = { Text("Configuracion") }
                )
                NavigationBarItem(
                    selected = index == 3,
                    onClick = {
                        index = 3
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Perfil"
                        )
                    },
                    label = { Text("Perfil") }
                )

            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { contentPadding ->
        Cuerpo01(
            modifier = Modifier.padding( contentPadding ),
            snackbarHostState = snackbarHostState
        )
    }
}
@Composable
fun Cuerpo01(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState
) {
    var color by remember { mutableStateOf(Color.White) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable {
                    color = Color.White
                    scope.launch {
                        snackbarHostState.showSnackbar("Tema Claro activado")
                    }
                },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Text("Claro")
            Text("Cambia el fondo a Blanco")
            ImagenDesdeUrl("https://cdn-icons-png.freepik.com/512/106/106061.png")
        }

        Card(
            modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable {
                    color = Color.Gray
                    scope.launch {
                        snackbarHostState.showSnackbar("Tema Oscuro activado")
                    }
                },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Text("Oscuro")
            Text("Cambia el fondo a Gris")
            ImagenDesdeUrl("https://cdn-icons-png.flaticon.com/512/91/91466.png")
        }

        Card(
            modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable {
                    color = Color.Blue
                    scope.launch {
                        snackbarHostState.showSnackbar("Tema Sistema activado")
                    }
                },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Text("Sistema")
            Text("Cambia el fondo a Azul")
            ImagenDesdeUrl("https://cdn-icons-png.flaticon.com/512/2289/2289316.png")
        }
    }
}

@Composable
fun ImagenDesdeUrl(imagen: String) {
    val url = if (imagen.isNullOrBlank()) {
        val randomSize = (1..1000).random()
        "https://picsum.photos/$randomSize"

    } else {
        imagen
    }
    AsyncImage(
        model = url,
        contentDescription = "Mi imagen",
        modifier = Modifier.fillMaxWidth(),
        onError = { state ->
            Log.e("COIL", "Error al cargar imagen", state.result.throwable)
        }
    )
}

