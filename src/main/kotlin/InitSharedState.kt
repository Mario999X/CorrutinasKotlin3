import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import models.modelsSharedFlow.IASharedFlow
import models.modelsSharedFlow.TrabajadorSharedFlow

object InitSharedState {

    fun init(maxCapsulas: Int) = runBlocking {
        val ia = IASharedFlow("Cortana")
        val trabajadores = listOf(TrabajadorSharedFlow("Master Chief"), TrabajadorSharedFlow("Kratos"))

        launch { ia.producirCapsulas(maxCapsulas) }

        trabajadores.forEach { t ->
            launch { t.lanzarCapsulas(ia.capsulas) }
        }
    }
}