// Import necessary Kotlin packages and classes.
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Define a base class named SmartDevice with primary constructor parameters name and category.
open class SmartDevice(val name: String, val category: String) {

    // Declare a property deviceStatus with a default value "online". The setter is protected,
    // meaning it can only be accessed within this class and its subclasses.
    var deviceStatus = "online"
        protected set

    // Declare a property deviceType with a default value "unknown". The property is open and can be
    // overridden by subclasses.
    open val deviceType = "unknown"

    // Define an open method turnOn() that sets the deviceStatus to "on".
    open fun turnOn() {
        deviceStatus = "on"
    }

    // Define an open method turnOff() that sets the deviceStatus to "off".
    open fun turnOff() {
        deviceStatus = "off"
    }
}

// Define a subclass SmartTvDevice that inherits from SmartDevice and takes deviceName and deviceCategory parameters.
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    // Override the deviceType property to "Smart TV".
    override val deviceType = "Smart TV"

    // Declare a private property speakerVolume using a custom delegate RangeRegulator.
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    // Declare a private property channelNumber using a custom delegate RangeRegulator.
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    // Override the turnOn() method to provide additional information when turning on the TV.
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    // Override the turnOff() method to provide information when turning off the TV.
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    // Define a method to increase the speaker volume.
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    // Define a method to change to the next TV channel.
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
}

// Define a subclass SmartLightDevice that inherits from SmartDevice and takes deviceName and deviceCategory parameters.
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    // Override the deviceType property to "Smart Light".
    override val deviceType = "Smart Light"

    // Declare a private property brightnessLevel using a custom delegate RangeRegulator.
    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    // Override the turnOn() method to provide information about brightness when turning on the light.
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name is turned on. The brightness level is $brightnessLevel.")
    }

    // Override the turnOff() method to provide information when turning off the light.
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off")
    }

    // Define a method to increase the brightness level.
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
}

// Define a class SmartHome that takes instances of SmartTvDevice and SmartLightDevice.
class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {

    // Declare a property deviceTurnOnCount with an initial value of 0 and a private setter.
    var deviceTurnOnCount = 0
        private set

    // Define methods to control various devices in the smart home.
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// Define a custom delegate RangeRegulator.
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

// Define the main function where the program execution starts.
fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )


    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    // Turn on the TV and light, and print the total number of devices turned on.
    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()
}

//
