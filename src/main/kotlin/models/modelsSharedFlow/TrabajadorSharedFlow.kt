package models.modelsSharedFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import models.Capsula

data class TrabajadorSharedFlow(val id: String) {

    suspend fun lanzarCapsulas(capsulasFlow: SharedFlow<Capsula>) {
        capsulasFlow.buffer(1).distinctUntilChanged().collect { capsula ->
            println("----------------------------------------------------------------")
            println("Trabajador: $id | Capsula: $capsula")

            delay(capsula.tiempoLanzamiento)

            println("\t --Trabajador: $id lanzo la capsula -> $capsula ")
        }
        println("\t---- Trabajador: $id finalizo")
    }
}
