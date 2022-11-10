package models.modelsFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import models.Capsula

// IA para flujos
data class IAFlow(val id: String) {

    /*
    * Metodo que produce capsulas, se le pasa un numero de capsulas por parametro
    *
    * Indicamos = flow y emitimos el item generado
    *
    * No es necesario que el metodo sea suspend
    * */
    fun producirCapsulas(maxCapsulas: Int) = flow {
        for (i in 1..maxCapsulas) {
            delay((200..500).random().toLong())
            val capsula = Capsula(i, id)
            println("IA: $id | Capsula -> $capsula")
            emit(capsula)
        }
    }
}
