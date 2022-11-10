package models.modelsFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.distinctUntilChanged
import models.Capsula

// Trabajador para flujos
data class TrabajadorFlow(val id: String) {

    /*
    * Metodo que lanza capsulas, se le pasa un flujo por parametro
    *
    * Recolectamos cada capsula de forma individual, seleccione un buffer de 1
    * Luego, lo de siempre, se muestra al trabajador, la capsula que ha seleccionado
    * y aplicamos un delay con el tiempo de la capsula.
    *
    * Cuando no reciba ninguna capsula mas, finaliza y muestra ese mensaje final.
    */
    suspend fun lanzaCapsulas(capsulasFlow: Flow<Capsula>) {
        capsulasFlow.buffer(1).distinctUntilChanged().collect { capsula ->
            println("----------------------------------------------------------------")
            println("Trabajador: $id | Capsula: $capsula")

            delay(capsula.tiempoLanzamiento)

            println("\t --Trabajador: $id lanzo la capsula -> $capsula ")
        }
        println("\t---- Trabajador: $id finalizo")
    }
}
