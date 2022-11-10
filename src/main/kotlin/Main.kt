private const val MAX_CAPSULAS = 5

fun main() {

    /* -- FLOWS --
    *
    * Cuando se produce una capsula, los trabajadores escuchan, y estos reaccionan a ejecutar su unico metodo
    *
    * Incluyo codigo comentado, donde se puede ver como se ejecutaria con varios consumidores
    *
    * Recomiendo un numero bajo de capsulas (2) en esta ejecucion, en especial si se hace con varios consumidores.
    */

    //InitFlow.init(MAX_CAPSULAS)


    /* -- STATE FLOW --
    *
    * El uso de este tipo de flujo es el idoneo para aplicar el uso de un monitor
    *
    * Este caso lo he dejado como el anterior, dos productores un consumidor, pero con
    * la opcion de dos consumidores, solo hay que comentar y descomentar las partes necesarias
    *
    * Este funciona mas parecido a un productor-consumidor de toda la vida, la nave no tiene un buffer limitado.
    */

    InitStateFlow.init(MAX_CAPSULAS)
}