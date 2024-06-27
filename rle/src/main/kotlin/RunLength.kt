package darty.kata

data class RunLength(val str: String)

fun encode(str: String): RunLength {
    return if (str.isEmpty()) RunLength("") else RunLength(process(str))
}

private fun process(str: String) = compute(str, str.last(), 0, "")

private fun compute(str: String, char: Char, count: Int, acc: String): String {
    if (str.isEmpty()) return "$count$char".plus(acc)

    return if(str.last().equals(char))
        compute(str.dropLast(1), char, count.plus(1), acc)
    else
        compute(str, str.last(), 0, "$count$char".plus(acc))
}