package learn

interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice : InputDevice

interface BLEInputDevice : InputDevice

interface OpticalDevice

class USBMouse(val name: String): USBInputDevice, OpticalDevice {
    override fun input(event: Any) {
        println("USB mouse")
    }

    override fun toString(): String {
        return name
    }
}

class Computer {
    private fun addUSBInputDevice(usbInputDevice: USBInputDevice) {
        println("add usb input device $usbInputDevice")
    }

    private fun addBLEInputDevice(bleInputDevice: BLEInputDevice) {
        println("add ble input device $bleInputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is USBInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            is BLEInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            else -> {
                throw IllegalArgumentException("The input device is not support!!!")
            }
        }
    }
}


fun main() {
    val computer = Computer()
    val mouse = USBMouse("Apple.")
    computer.addInputDevice(mouse)
}