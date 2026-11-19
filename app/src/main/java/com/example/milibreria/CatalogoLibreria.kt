package com.example.milibreria

class CatalogoLibreria(
    val autores: List<Autor>,
    val libros: List<Libro>
) {
    fun listarAutores(): List<Autor> = autores

    fun listarLibros(): List<Libro> = libros

    fun buscarLibros(texto: String): List<Libro> =
        libros.filter {
            it.titulo.contains(texto, ignoreCase = true)
        }

    companion object {
        fun crearEjemplo(): CatalogoLibreria {

            val autor1 = Autor(
                1, "Gabriel García Márquez", "Colombia"
            )

            val autor2 = Autor(
                2, "Isabel Allende", "Chile"
            )

            val autor3 = Autor(
                3, "Julio Verne", "Francia"
            )

            return CatalogoLibreria(
                autores = listOf(autor1, autor2, autor3),

                libros = listOf(
                    Libro(
                        1, "Cien años de soledad",
                        autor1, "Novela", 85.0, 7
                    ),
                    Libro(
                        2, "La casa de los espíritus",
                        autor2, "Novela", 70.0, 4
                    ),
                    Libro(
                        3, "Viaje al centro de la Tierra",
                        autor3, "Aventura", 55.0, 12
                    ),
                    Libro(
                        4, "El amor en los tiempos del cólera",
                        autor1, "Novela", 78.0, 0
                    )
                )
            )
        }
    }
}