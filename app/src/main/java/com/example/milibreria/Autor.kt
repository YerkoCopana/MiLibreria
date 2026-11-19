package com.example.milibreria

data class Autor(
    val id: Int,
    val nombre: String,
    val nacionalidad: String
) {
    fun descripcion(): String {
        return "$nombre - $nacionalidad"
    }
}