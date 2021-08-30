package chains

/**
 * CarEngine
 *
 * @author john
 * @since 2021-08-30
 */
class CarEngine(var engineType: EngineType) : Chain.ChainUnit {
    fun needRecharge(): Boolean {
        return engineType == EngineType.ELECTRIC
    }

    fun causesPollution(): Boolean {
        return engineType == EngineType.DIESEL || engineType == EngineType.PETROL
    }
}