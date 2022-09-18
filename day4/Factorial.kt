import java.math.BigInteger
/* 
cerner_2tothe5th_2022
cerner 2^5_2022

Day 4: first kotlin program. Decided to go with factorial recursion for this.
*/

// Calculate the factorial output of the given value.
fun factorial(base: Int, sum: BigInteger): BigInteger {
    if (base == 0 || base == 1) {
        return sum
    }
    else {
        var newSum = sum.multiply(base.toBigInteger())
        return factorial(base - 1, newSum)
    }
}

fun main() {
    println("\nLets do some factorial math in honor of Programming Day!\nLets calculate the factorials for all terms involved in problem 2^5 = 32\n")

    var initialSum = BigInteger.valueOf(1)

    var twoFactorial = factorial(2, initialSum)
    println("The result of 2! is: $twoFactorial")

    var fiveFactorial = factorial(5, initialSum)
    println("The result of 5! is: $fiveFactorial")

    var thirtyTwoFactorial = factorial(32, initialSum)
    println("The result of 32! is: %,d".format(thirtyTwoFactorial))
}
