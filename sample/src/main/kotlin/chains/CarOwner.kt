package chains

/**
 * CarOwner
 *
 * @author john
 * @since 2021-08-30
 */
class CarOwner(var name: String, var licenceNo: String, var address: String) : Chain.ChainUnit {
    fun isLicenceExpired(): Boolean {
        // Some logic based on licenceNo
        // dummy response
        return false
    }

    override fun toString(): String {
        return "CarOwner(name='$name', licenceNo='$licenceNo', address='$address')"
    }
}