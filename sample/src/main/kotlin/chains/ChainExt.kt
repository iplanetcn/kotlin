package chains

/**
 * ChainExt
 *
 * @author john
 * @since 2021-08-30
 */
fun Chain.carEngineType(engineType: EngineType): Chain = this.then(
    CarEngine(engineType)
)

fun Chain.carOwnerDetails(name: String, licenceNo: String, address: String): Chain = this.then(
    CarOwner(name, licenceNo, address)
)

fun Chain.carSpecs(wheelCount: Int, seats: Int, manufacturer: String) :Chain = this.then(
    CarSpecs(wheelCount, seats, manufacturer)
)

fun Chain.carVisuals(color: String) : Chain = this.then(
    CarVisuals(color)
)