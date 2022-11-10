package models.modelsStateFlow

import kotlinx.coroutines.delay
import models.modelsStateFlow.monitor.Nave

data class TrabajadorStateFlow(val id: String) {

    var contador: Int = 0

    suspend fun lanzaCapsulas(nave: Nave) {
        while (contador < 3) {
            if (nave.capsulasDisponibles > 0) {
                val capsula = nave.getCapsula()

                println("----------------------------------------------------------------")
                println("Trabajador: $id | Capsula: $capsula")

                delay(capsula.tiempoLanzamiento)

                println("\t --Trabajador: $id lanzo la capsula -> $capsula ")
            } else {
                println("Nave sin capsulas | Trabajador $id esperando...")
                delay(500)
                contador++
            }
        }
        println("\t---- Trabajador: $id finalizo")
    }
}
