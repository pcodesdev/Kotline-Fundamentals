// Define an open class named SmartDevice with a primary constructor that takes 'name' and 'category' parameters.
open class SmartDevice(val name: String, val category: String) {
    // Declare a property 'deviceType' with default value "Unknown".
    open val deviceType = "Unknown"

    // Declare a property 'deviceStatus' with default value "online".
    var deviceStatus = "online"

    // Define a secondary constructor that takes 'name', 'category', and 'statusCode' parameters.
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        // Determine 'deviceStatus' based on 'statusCode' using a when expression.
        val deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
        println("The device status is $deviceStatus")
    }

    // Define open methods to turn on and turn off the device.
    open fun turnOn() {
        println("Smart device is turned on")
    }

    open fun turnOff() {
        println("Smart device is turned off")
    }
}

// Create a subclass SmartTvDevice that inherits from SmartDevice and takes 'deviceName' and 'deviceCategory' parameters.
class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    // Override the 'deviceType' property.
    override val deviceType = "Smart TV"

    // Define properties for speaker volume and channel number.
    var speakerVolume = 2
    var channelNumber = 1

    // Override the 'turnOn' method to print additional information.
    override fun turnOn() {
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber.")
    }

    // Define methods to adjust speaker volume and channel.
    fun setSpeakerVolume() {
        speakerVolume++
        println("The speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("The channel number increased to $channelNumber.")
    }
}

// Create another subclass SmartLightDevice that inherits from SmartDevice.
class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    // Override the 'deviceType' property.
    override val deviceType = "Smart Light"

    // Define a property for brightness level.
    var brightnessLevel = 0

    // Override the 'turnOn' method to print additional information.
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. Brightness Level is $brightnessLevel.")
    }

    // Define a method to increase brightness.
    fun increaseBrightness() {
        brightnessLevel++
        println("The brightness level increased to $brightnessLevel.")
    }
}

// Create a class SmartHome that takes SmartTvDevice and SmartLightDevice instances.
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    // Define methods to control the devices.
    fun turnOnTV() {
        smartTvDevice.turnOn()
    }

    fun turnOffTV() {
        smartTvDevice.turnOff()
    }

    fun increaseTVVolume() {
        smartTvDevice.setSpeakerVolume()
    }

    fun changeChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun brightnessLevel() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTV()
        turnOffLight()
    }
}

// Main function
fun main() {
    // Create an instance of SmartTvDevice and call its methods.
    var smartDevice: SmartDevice = SmartTvDevice("Android Smart TV", "Entertainment")
    smartDevice.turnOn()

    // Create an instance of SmartLightDevice and call its methods.
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}
