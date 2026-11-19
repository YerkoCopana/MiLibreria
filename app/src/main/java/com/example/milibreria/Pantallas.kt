package com.example.milibreria

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PantallaLibros(
    libros: List<Libro>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Catálogo de libros",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(libros, key = { it.id }) { libro ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = libro.titulo,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(Modifier.height(6.dp))

                        Text("Autor: ${libro.autor.nombre}")
                        Text("Género: ${libro.genero}")
                        Text("Precio: Bs ${libro.precio}")

                        Text(
                            text = if (libro.disponible()) {
                                "Disponible: ${libro.stock} unidades"
                            } else {
                                "Agotado"
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PantallaAutores(
    autores: List<Autor>,
    libros: List<Libro>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Nuestros autores",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(autores, key = { it.id }) { autor ->

                val cantidad = libros.count {
                    it.autor.id == autor.id
                }

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = autor.nombre,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(Modifier.height(6.dp))

                        Text(
                            "Nacionalidad: ${autor.nacionalidad}"
                        )

                        Text(
                            "Libros en catálogo: $cantidad"
                        )
                    }
                }
            }
        }
    }
}