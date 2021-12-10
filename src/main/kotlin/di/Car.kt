package di

class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

class AnotherCar {
    private val engine = ServiceLocator.getEngine()

    fun start() {
        engine.start()
    }
}

fun main() {
    val engine = BmwGasEngine()
    val car = Car(engine)
    car.start()

    val anotherCar = AnotherCar()
    anotherCar.start()
}