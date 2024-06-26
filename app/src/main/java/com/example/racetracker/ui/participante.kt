
package com.example.racetracker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay


class Participante(
    val nombre: String,
    val ProgresoMax: Int = 100,
    val progressDelayMillis: Long = 500L,
    private val VelocidadProceso: Int = 1,
    private val ProgresoInic: Int = 0
) {
    init {
        require(ProgresoMax > 0) { "ProgresoMaximo=$ProgresoMax; " }
        require(VelocidadProceso > 0) { "IncrementodeProceso=$VelocidadProceso; " }
    }


    var ProgresoActual by mutableStateOf(ProgresoInic)
        private set


    suspend fun run() {
        while (ProgresoActual < ProgresoMax) {
            delay(progressDelayMillis)
            ProgresoActual += VelocidadProceso
        }
    }

    fun reset() {
        ProgresoActual = 0
    }
}

val Participante.progressFactor: Float
    get() = ProgresoActual / ProgresoMax.toFloat()
