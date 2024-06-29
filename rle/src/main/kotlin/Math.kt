package darty.kata

fun power(value: Int, exponent: Int): Int {
    if(exponent == 0) return 1
    return value * power(value, exponent-1)
}