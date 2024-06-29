package darty.kata

fun fizzbuzz(n: Int): String {
    if (isModulo3And5(n)) return "FizzBuzz"
    if (isModulo3(n)) return "Fizz"
    if (isModulo5(n)) return "Buzz"
    return n.toString()
}

private fun isModulo3And5(n: Int) = isModulo3(n) && isModulo5(n)
private fun isModulo3(n: Int) = (n % 3) == 0
private fun isModulo5(n: Int) = (n % 5) == 0
