package darty.kata

import kotlin.math.pow
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    val abs = abs();

    operator fun plus(complex: ComplexNumber): ComplexNumber {
        return ComplexNumber(real + complex.real, imag + complex.imag)
    }

    operator fun minus(complex: ComplexNumber): ComplexNumber {
        return ComplexNumber(real - complex.real, imag - complex.imag)
    }

    operator fun times(complex: ComplexNumber): ComplexNumber {
        return ComplexNumber((real * complex.real - imag * complex.imag), (imag * complex.real - real + complex.imag))
    }

    operator fun div(complex: ComplexNumber): ComplexNumber {
        return this.times(complex.reciprocate())
    }

    fun conjugate(): ComplexNumber {
        return ComplexNumber(real, -imag)
    }

    private fun abs(): Double {
        return sqrt(real.pow(2) + imag.pow(2))
    }

    private fun reciprocate(): ComplexNumber {
        if (isZero()) throw UnsupportedOperationException("Division by zero")
        return ComplexNumber(real.div(real.pow(2) + imag.pow(2)), -imag.div(real.pow(2) + imag.pow(2)))
    }

    private fun isZero() = real == 0.0 && imag == 0.0
}