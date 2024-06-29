import darty.kata.fizzbuzz
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FizzBuzzKtTest {

    @ParameterizedTest
    @MethodSource("params")
    fun should_compute_fizzbuzz_for_a_given_number(given: Int, expected: String) {
        assert(expected.equals(fizzbuzz(given)))
    }

    companion object {
        @JvmStatic
        fun params(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(2, "2"),
                Arguments.of(3, "Fizz"),
                Arguments.of(4, "4"),
                Arguments.of(5, "Buzz"),
                Arguments.of(6, "Fizz"),
                Arguments.of(7, "7"),
                Arguments.of(8, "8"),
                Arguments.of(9, "Fizz"),
                Arguments.of(10, "Buzz"),
                Arguments.of(11, "11"),
                Arguments.of(12, "Fizz"),
                Arguments.of(13, "13"),
                Arguments.of(14, "14"),
                Arguments.of(15, "FizzBuzz"),
                Arguments.of(16, "16"),
                Arguments.of(17, "17"),
                Arguments.of(18, "Fizz"),
                Arguments.of(19, "19"),
                Arguments.of(20, "Buzz"),
                Arguments.of(30, "FizzBuzz"),
                Arguments.of(100, "Buzz"),
                Arguments.of(333, "Fizz"),
            )
        }
    }
}