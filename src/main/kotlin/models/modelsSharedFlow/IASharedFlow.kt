package models.modelsSharedFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import models.Capsula

data class IASharedFlow(val id: String) {

    private val _capsulas = MutableSharedFlow<Capsula>()
    val capsulas: SharedFlow<Capsula> = _capsulas.asSharedFlow()

    suspend fun producirCapsulas(maxCapsulas: Int) {
        for (i in 1..maxCapsulas) {
            delay((200..500).random().toLong())
            val capsula = Capsula(i, id)
            println("IA: $id | Capsula -> $capsula")
            _capsulas.emit(capsula)
        }
    }
}
