//special auction

fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // Fill in the code.
//    bid?.amount: This part uses the safe call operator ?.. The safe call operator is used with nullable variables to access their properties or methods without causing a null pointer exception. In this case, it checks if the bid object is not null, and if it is not null, it accesses the amount property of the bid object.
//
//    ?:: This is the Elvis operator. It's used to provide a default value when the expression on its left side evaluates to null. In this case, if bid?.amount is null, the expression on the right side of ?: will be used as the result.
//
//    minimumPrice: This is the default value to use when bid?.amount is null. If bid?.amount is null, the value of minimumPrice will be returned.
//
//    Putting it all together, the expression bid?.amount ?: minimumPrice can be understood as follows:
//
//    If bid is not null, return the value of bid.amount.
//    If bid is null, return the value of minimumPrice.
    return bid?.amount ?: minimumPrice
}


//class Bid(val amount: Int, val bidder: String)
//
//fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
//    return bid?.amount ?: minimumPrice
//}
//
//fun main() {
//    val winningBid = Bid(5000, "Private Collector")
//
//    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
//    println("Item B is sold at ${auctionPrice(null, 3000)}.")
//}
