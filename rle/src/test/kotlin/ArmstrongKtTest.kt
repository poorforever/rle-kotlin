import darty.kata.isArmstrong
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ArmstrongKtTest {
    @ParameterizedTest
    @MethodSource("params")
    fun isArmstrong(given: Int, expected: Boolean) {
        assertEquals(expected, isArmstrong(given))
    }

    companion object {
        @JvmStatic
        fun params(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1, true),
                Arguments.of(9, true),
                Arguments.of(10, false),
                Arguments.of(153, true),
                Arguments.of(154, false),
                Arguments.of(370, true),
                Arguments.of(371, true),
                Arguments.of(372, false),
                Arguments.of(407, true),
                Arguments.of(1634, true),
            )
        }
    }
}