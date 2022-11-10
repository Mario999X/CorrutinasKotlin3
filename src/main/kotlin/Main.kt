import capsulasFlow.InitFlow

private const val MAX_CAPSULAS = 2

fun main(){

    /* -- FLOWS --
    *
    * Cuando se produce una capsula, los trabajadores escuchan, y estos reaccionan a ejecutar su unico metodo
    *
    * Incluyo codigo comentado, donde se puede ver como se ejecutaria con varios consumidores
    *
    * Recomiendo un numero bajo de capsulas en esta ejecucion, en especial si se hace con varios consumidores.
    */
    InitFlow.init(MAX_CAPSULAS)


    
}