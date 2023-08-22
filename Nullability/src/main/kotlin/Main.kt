fun main(){
    var favoriteActor: String?= "Churchill";

actor()
}

////01 Challenge: change an Int type to null
//
//fun num(){
//    var number: Int? = 5
//
//    print("$number\n")
//
//    number=null
//    print(number)
//}

////02 Handling nullable variables
//fun actor() {
//    var favoriteActor: String? = "Samidoh"
//
////    Use the ?. safe-call operator
//    print("${favoriteActor?.length}\n")
//
//    favoriteActor=null
//    println(favoriteActor)
//}




//    favoriteActor=null
//    print(favoriteActor)
//}

////03 Use the !! not-null assertion operator
//fun actor() {
//    var favoriteActor: String? = null
//
//    print(favoriteActor!!.length)
//
////    favoriteActor=null
////    println(favoriteActor)
//}
//
////Use the if/else conditionals
//fun actor() {
//    var favoriteActor: String? = null
//
//    if (favoriteActor != null) {
//        print("Your favorite actor is name is  ${favoriteActor.length} characters long")
//    }else{
//        println("You did input a number")
//    }



//    favoriteActor=null
//    println(favoriteActor)
//}

////use the if/else expression
//fun actor() {
//    var favoriteActor: String? = "Peter"
//
//    val mainActor= if (favoriteActor != null) {
//       favoriteActor.length
//    }else {
//        0
//    }
//    println(mainActor)
//    }

//Use the ?: Elvis operator
fun actor() {
    var favoriteActor: String? = null

    val nameLength=favoriteActor?.length?:0
    println("The length of your name is ${nameLength}")
}