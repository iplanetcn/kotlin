package chains

/**
 * Car
 *
 * @author john
 * @since 2021-08-30
 */
class Car private constructor(chainer: Chain) : Vehicle {
    private var carEngine: CarEngine? = null
    private var carOwner: CarOwner? = null
    private var carSpecs: CarSpecs? = null
    private var carVisuals: CarVisuals? = null

    companion object {
        fun compose(chainer: Chain): Car {
            return chainer.fold(Car(chainer)) { car, chainUnit ->
                when (chainUnit) {
                    is CarEngine -> car.carEngine = chainUnit
                    is CarOwner -> car.carOwner = chainUnit
                    is CarSpecs -> car.carSpecs = chainUnit
                    is CarVisuals -> car.carVisuals = chainUnit
                }
                car
            }
        }
    }

    override fun isSafeForEnvironment(): Boolean {
        return if (carEngine != null) {
            !carEngine!!.causesPollution()
        } else {
            false
        }
    }

    override fun color(): String {
        return carVisuals!!.color
    }

    override fun seatCapacity(): Int {
        return carSpecs!!.seats
    }

    override fun ownerDetails(): String {
        return carOwner!!.toString()
    }

    override fun wheels(): Int {
        return carSpecs!!.wheelCount
    }

    override fun manufacturer(): String {
        return carSpecs!!.manufacturer
    }
}