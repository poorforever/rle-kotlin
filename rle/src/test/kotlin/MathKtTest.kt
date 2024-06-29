import darty.kata.power
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MathKtTest {

    @ParameterizedTest
    @MethodSource("params")
    fun should_compute_power(givenValue: Int, givenExponent: Int, expected: Int) {
        assertEquals(expected, power(givenValue, givenExponent))
    }

    companion object {
        @JvmStatic
        fun params(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, 0, 1),
                Arguments.of(10, 0, 1),
                Arguments.of(333, 0, 1),
                Arguments.of(2, 2, 4),
                Arguments.of(2, 3, 8),
                Arguments.of(2, 8, 256),
            )
        }
    }
}