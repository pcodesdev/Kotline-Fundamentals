//parameterized constructor
//primary constructor

open class SmartDevice(val name: String, val category: String){
//    Class properties
//    Override superclass properties from subclasses
    open val deviceType="Unknown"
    var deviceStatus = "online"
//    secondary constructor

    constructor(name: String, category: String, statusCode: Int) : this(name, category){
        val deviceStatus = when(statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
        println("The device status is $deviceStatus")
    }
//    Class methods
//    Override methods using the open keyword
    open fun turnOn(){
        println("Smart device is turned on")
    }

   open fun turnOff(){
        println("Smart device is turned off")
    }
}

//Implementing class inheritance
//IS-A relationships
// The SmartHome class HAS-A smart TV device.
class SmartTvDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory) {

        override val deviceType="Smart TV"
//        use of setters and getters
    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }

        }

    var channelNumber=1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }


    override fun turnOn() {
      super.turnOn()

        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is \" +\n" +
                "                \"set to $channelNumber.")
    }

    override fun turnOff() {
      super.turnOff()
        println("$name is turned off.")
    }
    fun setSpeakerVolume(){
        speakerVolume ++
        println("The speaker volume increased to $speakerVolume.")
    }

    fun nextChannel(){
        channelNumber ++
        println("The channel number increased to $channelNumber.")
    }

}



class SmartLightDevice(deviceName: String, deviceCategory: String): SmartDevice(name=deviceName, category=deviceCategory) {

    override val deviceType="Smart Light"


    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    override fun turnOn() {
       super.turnOn()
        brightnessLevel =2
        print("$name turned on. Brightness Level is $brightnessLevel.")
    }

    override fun turnOff() {
       super.turnOff()
        brightnessLevel =0
        print("$name turned off. Brightness Level is $brightnessLevel.")

    }
    fun increaseBrightness() {
        brightnessLevel++

        println("The brightness level increased to $brightnessLevel.")
    }
}

class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice : SmartLightDevice){
    fun turnOnTV() {
        smartTvDevice.turnOn()

    }

    fun turnOffTV() {
        smartTvDevice.turnOff()
    }

    fun increaseTVVolume(){
        smartTvDevice.setSpeakerVolume()
    }

    fun changeChannelToNext(){
        smartTvDevice.nextChannel()
    }

    fun turnOnLight(){
        smartLightDevice.turnOn()
    }

    fun turnOffLight(){
        smartLightDevice.turnOff()
    }

    fun brightnessLevel(){

        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices(){
        turnOffTV()
        turnOffLight()
    }
}





//Main function
fun main() {

//    Instance of a class
    var smartDevice: SmartDevice =SmartTvDevice("Android Smart TV","Entertainment")
    smartDevice.turnOn()

    smartDevice=SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}