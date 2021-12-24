package chains

/**
 * Chain
 *
 * @author john
 * @since 2021-08-30
 */
interface Chain {
    fun <R> fold(initial: R, operation: (R, ChainUnit) -> R) : R

    fun then(other: Chain) : Chain = LinkedChain(this, other)

    interface ChainUnit: Chain{
        override fun <R> fold(initial: R, operation: (R, ChainUnit) -> R): R =  operation(initial, this)
    }

    companion object: Chain {
        override fun <R> fold(initial: R, operation: (R, ChainUnit) -> R): R  = initial

        override fun then(other: Chain): Chain = other
    }
}