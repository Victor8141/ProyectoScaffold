package com.example.proyectoscaffold.Ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@Composable
fun PerfilApp() {
    var selectedTab by remember { mutableStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = { Text("Mi perfil") },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    label = { Text("Perfil") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    label = { Text("Notificaciones") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    label = { Text("Ajustes") },
                    icon = {}
                )
            }
        }
    ) { padding ->
        when (selectedTab) {
            0 -> PantallaPerfil(snackbarHostState, Modifier.padding(padding))
            1 -> PantallaNotificaciones(Modifier.padding(padding))
            2 -> PantallaAjustes(Modifier.padding(padding))
        }
    }
}

@Composable
fun PantallaPerfil(snackbar: SnackbarHostState, modifier: Modifier = Modifier) {
    var avatarUrl by remember {
        mutableStateOf("https://images.vexels.com/media/users/3/137047/isolated/preview/5831a17a290077c646a48c4db78a81bb-icono-de-perfil-de-usuario-azul.png")
    }
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = avatarUrl,
            contentDescription = "Avatar",
            modifier = Modifier.size(150.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text("Victor Sanchez", style = MaterialTheme.typography.titleMedium)
        Text("Victor123@gmail.com")
        Spacer(Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                avatarUrl = "https://images.vexels.com/media/users/3/137047/isolated/preview/5831a17a290077c646a48c4db78a81bb-icono-de-perfil-de-usuario-azul.png"
                scope.launch { ("Avatar actualizado") }
            }) { Text("Avatar 1") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = {
                avatarUrl = "https://cdn-icons-png.flaticon.com/512/3135/3135768.png"
                scope.launch { ("Avatar actualizado") }
            }) { Text("Avatar 2") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = {
                avatarUrl = "https://cdn-icons-png.flaticon.com/512/2920/2920072.png"
                scope.launch { ("Avatar actualizado") }
            }) { Text("Avatar 3") }
        }
    }
}

suspend fun mostrarSnackbar(snackbar: SnackbarHostState) {
    snackbar.showSnackbar("Avatar actualizado")
}

@Composable
fun PantallaNotificaciones(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("No tienes notificaciones")
    }
}

@Composable
fun PantallaAjustes(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        var emails by remember { mutableStateOf(true) }
        var oscuro by remember { mutableStateOf(false) }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Recibir emails")
            Spacer(Modifier.width(8.dp))
            Switch(checked = emails, onCheckedChange = { emails = it })
        }

        Spacer(Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Modo oscuro")
            Spacer(Modifier.width(8.dp))
            Switch(checked = oscuro, onCheckedChange = { oscuro = it })
        }
    }
}
