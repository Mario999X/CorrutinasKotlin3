import opciones.InitFlow
import opciones.InitSharedState
import opciones.InitStateFlow

private const val MAX_CAPSULAS = 4

fun main() {

    /* -- FLOW --
    *
    * https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/flow.html
    * Cuando se produce una capsula, los trabajadores escuchan, y estos reaccionan a ejecutar su unico metodo
    *
    * Incluyo codigo comentado, donde se puede ver como se ejecutaria con varios consumidores
    *
    * Recomiendo un numero bajo de capsulas (2) en esta ejecucion, en especial si se hace con varios consumidores.
    */

    //InitFlow.init(MAX_CAPSULAS)

    /* -- SHARED FLOW ---
    *
    * https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-shared-flow/
    *
    * Este es recomendable cuando se tiene un solo productor y varios consumidores, ya que a todos los consumidores
    * les va a llegar la misma informacion.
    *
    * Tiene un pero, que no es un pero, y es que no termina nunca, tante este como el State Flow son flujos calientes,
    * por lo que no terminan nunca, pero mientras que el State si detecta que ya no quedan capsulas en este caso no.
    */

    //InitSharedState.init(MAX_CAPSULAS)

    /* -- STATE FLOW --
    *
    * https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/
    * El uso de este tipo de flujo es el idoneo para aplicar el uso de un monitor
    *
    * Este caso lo he dejado como el anterior, dos productores un consumidor, pero con
    * la opcion de dos consumidores, solo hay que comentar y descomentar las partes necesarias
    *
    * Este funciona mas parecido a un productor-consumidor de toda la vida, la nave no tiene un buffer limitado.
    */

    InitStateFlow.init(MAX_CAPSULAS)
}