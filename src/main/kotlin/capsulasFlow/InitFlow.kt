package capsulasFlow

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import models.modelsFlow.IAFlow
import models.modelsFlow.TrabajadorFlow

object InitFlow {

    @OptIn(FlowPreview::class)
    fun init(maxCapsulas: Int) = runBlocking {

        val ias = listOf(IAFlow("Cortana"), IAFlow("Neo"))
        val trabajador = TrabajadorFlow("Joker")
        //val trabajadores = listOf(TrabajadorFlow("Master Chief"), TrabajadorFlow("Kratos"))

        val capsulasFlow = ias.asFlow().flatMapMerge(ias.size) { ia -> ia.producirCapsulas(maxCapsulas) }

        /*trabajadores.forEach { trabajador ->
            launch(Dispatchers.Default) {
                trabajador.lanzaCapsulas(capsulasFlow)
            }
        }
        */

        launch {
            trabajador.lanzaCapsulas(capsulasFlow)
        }
    }
}

/*
* Ese flatMapMerge puede parecer raro, otra alternativa sin recurrir a demasiadas lineas:
*
* val capsulasFlow = flowOf(ias[0].producirCapsulas(maxCapsulas), ias[1].producirCapsulas(maxCapsulas)).flattenMerge(ias.size)
*/