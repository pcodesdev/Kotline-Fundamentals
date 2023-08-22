//parameterized constructor
//primary constructor

class SmartDevice(val name: String, val category: String){
//    Class properties
    val deviceStatus = "online"
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
    fun turnOn(){
        println("Smart device is turned on")
    }

    fun turnOff(){
        println("Smart device is turned off")
    }
}



//Main function
fun main(){

//    Instance of a class
    val smartTvDevice=SmartDevice(name = "Android TV", category = "Entertainment", statusCode =0)
//    Call a method on an object
    println("Smart device is ${smartTvDevice.name}")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
    smartTvDevice.deviceStatus
}