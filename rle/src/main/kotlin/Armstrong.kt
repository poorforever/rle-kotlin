package darty.kata

fun isArmstrong(n: Int): Boolean {
    return n.toString().fold(0) { acc: Int, c: Char -> acc.plus(power(c.digitToInt(), n.toString().length)) } == n
}