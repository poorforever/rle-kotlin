import darty.kata.RunLength
import darty.kata.decode
import darty.kata.encode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RunLengthKtTest {
    @ParameterizedTest
    @MethodSource("encodeParameters")
    fun should_encode_run_length(given: String, expected: RunLength) {
        assertEquals(expected, encode(given))
    }

    @ParameterizedTest
    @MethodSource("decodeParameters")
    fun should_decode_run_length(given: String, expected: RunLength) {
        assertEquals(expected, decode(given))
    }

    companion object {
        @JvmStatic
        fun encodeParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("", RunLength("")),
                Arguments.of("A", RunLength("1A")),
                Arguments.of("B", RunLength("1B")),
                Arguments.of("AA", RunLength("2A")),
                Arguments.of("AAB", RunLength("2A1B")),
                Arguments.of("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW", RunLength("12W1B12W3B24W1B14W")),
                Arguments.of("AAAABBBCC", RunLength("4A3B2C")),
            )
        }

        @JvmStatic
        fun decodeParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("", RunLength("")),
                Arguments.of("1A", RunLength("A")),
                Arguments.of("1B", RunLength("B")),
                Arguments.of("2A", RunLength("AA")),
                Arguments.of("2A1B", RunLength("AAB")),
                Arguments.of("12W1B12W3B24W1B14W", RunLength("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW")),
                Arguments.of("4A3B2C", RunLength("AAAABBBCC")),
            )
        }
    }
}