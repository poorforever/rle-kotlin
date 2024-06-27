import darty.kata.RunLength
import darty.kata.encode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RunLengthKtTest {
    @ParameterizedTest
    @MethodSource("parameters")
    fun should_compute_run_length(given: String, expected: RunLength) {
        assertEquals(expected, encode(given))
    }

    companion object {
        @JvmStatic
        fun parameters(): Stream<Arguments> {
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
    }
}