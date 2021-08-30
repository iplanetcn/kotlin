package chains

/**
 * LinkedChain
 *
 * @author john
 * @since 2021-08-30
 */
class LinkedChain(
    private val outer: Chain,
    private val inner: Chain
) : Chain {
    override fun <R> fold(initial: R, operation: (R, Chain.ChainUnit) -> R): R =
        inner.fold(outer.fold(initial, operation), operation)
}