fun main(){
    traffic()
    primeNumber()
}

////if statement
//
//fun traffic(){
//    val trafficLightColor="Red"
//
//    if (trafficLightColor == "Red"){
//        println("Stop")
//    }
//}

////if else statement
//fun traffic(){
//    val trafficLightColor="Green"
//
//    if (trafficLightColor == "Red"){
//        println("Stop")
//    }else{
//        println("Go")
//    }
//}

////if else if else statement
//
//fun traffic(){
//    val trafficLightColor="Black"
//
//    if (trafficLightColor == "Red"){
//        println("Stop")
//    }else if (trafficLightColor == "Yellow"){
//        println("Slow")
//    } else if (trafficLightColor == "Green"){
//        println("Go")
//    }else{
//        println("Invalid Traffic-Light Color")
//    }
//}

////use when statement for multiple branches
//fun traffic(){
//    val trafficLightColor="Black"
//
//    when(trafficLightColor){
//        "Red" -> println("Stop")
//        "Yellow" -> println("Slow")
//        "Green" -> println("Go")
//        else -> println("Invalid Traffic-Light Color")
//
//    }

////Practice
//fun traffic(){
//    val trafficLightColor="Amber"
//
//    when(trafficLightColor){
//        "Red" -> println("Stop")
//        "Yellow", "Amber" -> println("Slow")
//        "Green" -> println("Go")
//        else -> println("Invalid Traffic-Light Color")
//
//    }

////    Convert an if statement to an expression
//fun traffic(){
//    val trafficLightColor="Amber"
//
//    val message = if (trafficLightColor == "Red") "Stop"
//    else if (trafficLightColor == "Yellow")
//            "Slow"
//        else if(trafficLightColor == "Green") "Go"
//        else
//            "Invalid Traffic-Light Color"
//
//    println(message)
//    }

//Convert the traffic-light program to use a when expression instead of a when statement:

fun traffic(){
    val trafficLightColor="Amber"

   val message= when (trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
       "Green" -> "Go"
            else -> "Invalid traffic light color"
    }
    println(message)
}

//    if (trafficLightColor == "Red"){
//        println("Stop")
//    }else if (trafficLightColor == "Yellow"){
//        println("Slow")
//    } else if (trafficLightColor == "Green"){
//        println("Go")
//    }else{
//        println("Invalid Traffic-Light Color")
//    }
//}

//Writing more complex when statements
fun primeNumber(){
    val num : Any=  20

    when(num){
//             Use a comma (,) for multiple conditions
       2, 3, 5, 7 -> println("$num is a prime number between 1 and 10")
//        3 -> println("3 is a prime number between 1 and 10")
//        5 -> println("5 is a prime number between 1 and 10")
//        7 -> println("7 is a prime number between 1 and 10")
//        Use the in keyword for a range of conditions
        in 1 .. 10 -> println("$num is a  number between 1 and 10, but it is not a prime number")

//        Use the is keyword to check data type
        is Int -> println("$num is an integer, but it is not within the range of 1 and 10")
        else -> println(" $num is not a an integer")
    }
}