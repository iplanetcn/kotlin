package com.phenix.chains

import chains.*
import org.junit.jupiter.api.Test

/**
 * FunctionChainsTest
 *
 * @author john
 * @since 2021-08-30
 */
class FunctionChainsTest {
    @Test
    internal fun testFolding() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val fold = numbers.fold(0) { total, number ->
            print("$total + $number --> ")
            total + number
        }
        println("fold:$fold")
        println("----------")

        val foldRight = numbers.foldRight(0) { total, number ->
            print("$total + $number --> ")
            total + number
        }
        println("foldRight:$foldRight")
        println("----------")
    }

    @Test
    internal fun testCarCompose() {
        // Composing our car
        val car = Car.compose(
            chainer = Chain.carEngineType(
                engineType = EngineType.ELECTRIC
            )
                .carOwnerDetails(
                    name = "John",
                    licenceNo = "SC8401D",
                    address = "Chengdu"
                )
                .carSpecs(
                    wheelCount = 4,
                    seats = 5,
                    manufacturer = "Tesla"
                )
                .carVisuals(
                    color = "Red"
                )
        )

        // Use the car
        println("Car.isSafeForEnvironment: ${car.isSafeForEnvironment()}")
        println("Car.ownerDetails: ${car.ownerDetails()}")
    }
}