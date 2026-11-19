package com.example.milibreria

data class Libro(
    val id: Int,
    val titulo: String,
    val autor: Autor,
    val genero: String,
    val precio: Double,
    val stock: Int
) {
    fun disponible(): Boolean {
        return stock > 0
    }

    fun precioConDescuento(porcentaje: Int): Double {
        require(porcentaje in 0..100) {
            "El descuento debe estar entre 0 y 100"
        }

        return precio * (1 - porcentaje / 100.0)
    }
}