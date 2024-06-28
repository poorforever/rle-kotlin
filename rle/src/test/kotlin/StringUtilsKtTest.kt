import darty.kata.repeatChar
import darty.kata.splitUsingRegex
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.Test

class StringUtilsKtTest {
    @ParameterizedTest
    @MethodSource("params")
    fun should_repeat_char(char: Char, count: Int, expected: String) {
        assertEquals(expected, repeatChar(char, count))
    }

    @Test
    fun should_split_using_regex() {
        val regex = "\\d+[A-Z]".toRegex()
        val phrase = "1A2B3C4D"

        val result = splitUsingRegex(phrase, regex)
        assert(result.size == 4)
    }

    companion object {
        @JvmStatic
        fun params(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("A", 0, ""),
                Arguments.of("A", 1, "A"),
                Arguments.of("A", 2, "AA"),
                Arguments.of("B", 3, "BBB"),
                Arguments.of("B", 10, "BBBBBBBBBB"),
            )
        }
    }
}