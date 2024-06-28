package darty.kata

data class RunLength(val str: String)

fun encode(str: String): RunLength {
    return if (str.isEmpty()) RunLength("") else RunLength(computeEncoding(str))
}

fun decode(str: String): RunLength {
    return if (str.isEmpty()) RunLength("") else RunLength(computeDecoding(str))
}

private fun computeEncoding(str: String) = computeEncoding(str, str.last(), 0, "")

private fun computeEncoding(str: String, char: Char, count: Int, acc: String): String {
    if (str.isEmpty()) return "$count$char".plus(acc)

    return if(str.last().equals(char))
        computeEncoding(str.dropLast(1), char, count.plus(1), acc)
    else
        computeEncoding(str, str.last(), 0, "$count$char".plus(acc))
}

private fun computeDecoding(str: String): String {
    return if (str.isEmpty()) ""
    else
        splitUsingRegex(str,"\\d+[A-Z]".toRegex()).fold("") { accumulator, res -> accumulator.plus(repeatChar("[A-Z]".toRegex().find(res)!!.value.first(), "\\d+".toRegex().find(res)!!.value.toInt()))}
}