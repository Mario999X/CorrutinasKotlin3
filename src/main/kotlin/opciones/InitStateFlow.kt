package opciones

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import models.modelsStateFlow.IAStateFlow
import models.modelsStateFlow.TrabajadorStateFlow
import models.modelsStateFlow.monitor.Nave

object InitStateFlow {

    fun init(maxCapsulas: Int) = runBlocking {
        val nave = Nave()

        val ias = listOf(IAStateFlow("Cortana", nave), IAStateFlow("Neo", nave))
        val trabajador = TrabajadorStateFlow("Master Chief")

        //val trabajadores = listOf(TrabajadorStateFlow("Master"), TrabajadorStateFlow("Kratos"))

        ias.forEach { i ->
            launch {
                i.producirCapsulas(maxCapsulas)
            }
        }

        launch {
            trabajador.lanzaCapsulas(nave)
        }

        /*trabajadores.forEach { t ->
            launch {
                t.lanzaCapsulas(nave)
            }
        }
        */
    }
}