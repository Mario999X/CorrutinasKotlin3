package models.modelsStateFlow

import kotlinx.coroutines.delay
import models.Capsula
import models.modelsStateFlow.monitor.Nave

data class IAStateFlow(val id: String, val nave: Nave) {

    suspend fun producirCapsulas(maxCapsulas: Int) {
        for (i in 1 until maxCapsulas) {
            delay((200..500).random().toLong())
            val capsula = Capsula(i, id)
            println("IA: $id | Capsula -> $capsula")
            nave.addCapsula(capsula)
        }
    }
}
