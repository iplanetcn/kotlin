package chains

/**
 * Vehicle
 *
 * @author john
 * @since 2021-08-30
 */
interface Vehicle {
    fun isSafeForEnvironment(): Boolean

    fun color(): String

    fun seatCapacity(): Int

    fun ownerDetails(): String

    fun wheels(): Int

    fun manufacturer(): String
}