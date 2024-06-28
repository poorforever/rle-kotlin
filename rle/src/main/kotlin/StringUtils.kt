package darty.kata

fun repeatChar(char: Char, count: Int): String {
    return repeatChar(char, count, "")
}

private fun repeatChar(char: Char, count: Int, acc: String): String {
    return if (count > 0)
        repeatChar(char, count.dec(), acc.plus(char))
    else acc
}

fun splitUsingRegex(str: String, regex: Regex): List<String> {
    return regex.findAll(str).map { it.value }.toList()
}