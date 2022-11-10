package models.modelsStateFlow.monitor

import kotlinx.coroutines.flow.MutableStateFlow
import models.Capsula

// Monitor
class Nave {
    private val capsulas = MutableStateFlow<List<Capsula>>(listOf())

    val capsulasDisponibles get() = capsulas.value.size

    // Agregamos capsulas
    fun addCapsula(capsula: Capsula) {
        println("Nave recibe: $capsula")
        capsulas.value += capsula
    }

    // Sacamos capsulas (una a una)
    fun getCapsula(): Capsula {
        val capsula = capsulas.value.first()
        capsulas.value = capsulas.value.drop(1)
        println("Nave envia: $capsula")
        return capsula
    }

    /* Si queremos tomar mas de una capsula a la vez, se usaria esto:
    * val capsulas = capsulas.value.take(3)
    * capsulas.value = capsulas.value.drop(3)
    *   Y devolveriamos una List<Capsula>
    */
}