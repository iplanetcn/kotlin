package di

class BmwGasEngine : GasEngine {
    override fun start() {
        println("BMW engine start.")
    }

    override fun stop() {
        println("BMW engine stop.")
    }
}