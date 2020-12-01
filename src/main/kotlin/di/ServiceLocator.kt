package di

object ServiceLocator {
    fun getEngine():Engine = BmwGasEngine()
}