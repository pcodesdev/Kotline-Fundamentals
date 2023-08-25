//Use function types and lambda expressions in Kotlin
//fun trick(){
//    println("No treats!")
//
//}

//Redefine the function with a lambda expression
val trick={
    println("No treats!")
}

// Use functions as a data type
//Specify the treat variable's data type as () -> Unit.
val treat:() -> Unit={
    println("Have a treat!")
}

//use of function as return type

fun trickOrTreat(isTreat:Boolean, extraTreat:((Int)-> String)?): () -> Unit{
if(isTreat){
    return trick
}else{
    if(extraTreat != null) {
        println(extraTreat(5))
    }
    return treat
}

}

fun main(){
////    calling a function
//    trick()
//    storing a function in a variable
//    to refer to a function as a value, you need to use the function reference operator (::).
//    val trickFunction=::trick
////    now trick is a variable not a function
//    val trickFunction=trick
//    trick()
//    trickFunction()
//    treat()

//    val coins:(Int)->String={
//        quantity->"$quantity quarters"
//    }

//    shorthand syntax
    val coins:(Int)->String={
            "$it quarters"
    }

    val cupCakes:(Int)->String={
      "Have a cup cake!"
    }

//    Use trailing lambda syntax
    val trickFunction= trickOrTreat(false){"$it quarters"}
    val treatFunction=trickOrTreat(true,null)

//    Use the repeat() function
   repeat(4) {
       trickFunction()
   }
    treatFunction()

}