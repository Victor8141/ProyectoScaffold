package com.example.proyectoscaffold.Ejercicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaProducto() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var selectedBottom by remember { mutableStateOf("Inicio") }

    // Imágenes del producto
    val imagenes = listOf(
        "https://m.media-amazon.com/images/I/61jmLD3hYaL._AC_SX679_.jpg",
        "https://m.media-amazon.com/images/I/6124U4tvjkL._AC_SX679_.jpg",
        "https://m.media-amazon.com/images/I/61kW+aq4g5L._AC_SX679_.jpg"
    )

    var imagenPrincipal by remember { mutableStateOf(imagenes[0]) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Auriculares Pro X") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Volver no implementado")
                        }
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // Permite scroll si el contenido es largo
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = imagenPrincipal,
                contentDescription = "Imagen Producto",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                imagenes.forEach { imgUrl ->
                    AsyncImage(
                        model = imgUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clickable { imagenPrincipal = imgUrl },
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Producto añadido al carrito")
                    }
                }
            ) {
                Text("Añadir al carrito")
            }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Compra rápida no disponible")
                    }
                }
            ) {
                Text("Comprar ahora")
            }

            Spacer(Modifier.height(24.dp))

            Text(
                "Sección activa: $selectedBottom",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

