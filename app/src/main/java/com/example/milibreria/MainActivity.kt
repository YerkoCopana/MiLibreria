package com.example.milibreria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AppLibreria()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLibreria() {

    val catalogo = remember {
        CatalogoLibreria.crearEjemplo()
    }

    var pantalla by rememberSaveable {
        mutableStateOf("Libros")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Mi Librería")
                }
            )
        },

        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = pantalla == "Libros",
                    onClick = {
                        pantalla = "Libros"
                    },
                    icon = {
                        Text("📚")
                    },
                    label = {
                        Text("Libros")
                    }
                )

                NavigationBarItem(
                    selected = pantalla == "Autores",
                    onClick = {
                        pantalla = "Autores"
                    },
                    icon = {
                        Text("👤")
                    },
                    label = {
                        Text("Autores")
                    }
                )
            }
        }
    ) { innerPadding ->

        when (pantalla) {

            "Libros" -> {
                PantallaLibros(
                    libros = catalogo.listarLibros(),
                    modifier = Modifier.padding(innerPadding)
                )
            }

            "Autores" -> {
                PantallaAutores(
                    autores = catalogo.listarAutores(),
                    libros = catalogo.listarLibros(),
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}