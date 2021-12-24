package chains

/**
 * CarVisuals
 *
 * @author john
 * @since 2021-08-30
 */
class CarVisuals(var color: String) : Chain.ChainUnit {
    fun isColorMetallic(): Boolean {
        return true
    }
}