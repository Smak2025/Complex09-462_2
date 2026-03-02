import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @ParameterizedTest
    @CsvSource({
            "0.0, 0.0, 0.0",
            "1.0, 0.0, 1.0",
            "0.0, 1.0, i",
            "-1.0, 0.0, -1.0",
            "0.0, -1.0, -i",
            "1.0, 1.0, 1.0+i",
            "-1.0, -1.0, -1.0-i",
            "1.0, -4.0, 1.0-4.0i",
            "1.0, 4.0, 1.0+4.0i",
            "Infinity, -Infinity, Infinity-Infinity i"
    })
    void testToString(double re, double im, String expected) {
        var z = new Complex(re, im);
        var actual = z.toString();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Сложение комплексных чисел")
    @MethodSource("plusArgsGenerator")
    void testPlus(Complex z1, Complex z2, Complex expected){
        var actual = z1.plus(z2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> plusArgsGenerator(){
        return Stream.of(new Arguments[]{
                Arguments.of(new Complex(1.0, 2.0), new Complex(-1.0, 2.0), new Complex(0.0, 4.0)),
                Arguments.of(new Complex(-1.0, 0.0), new Complex(-1.0, 2.0), new Complex(-2.0, 2.0))
        });
    }

    @ParameterizedTest
    @DisplayName("Хэш код")
    @MethodSource("hashCodeArgsGenerator")
    void testHashCode(Complex z1, Complex z2, boolean expected){
        var h1 = z1.hashCode();
        var h2 = z2.hashCode();
        assertEquals(expected, h1 == h2);
    }

    static Stream<Arguments> hashCodeArgsGenerator(){
        return Stream.of(new Arguments[]{
                Arguments.of(new Complex(1.0, 2.0), new Complex(1.0, 2.0), true),
                Arguments.of(new Complex(-1.0, 0.0), new Complex(-1.0, 2.0), false),
                Arguments.of(new Complex(1.0, 2.0), new Complex(2.0, 1.0), false),
        });
    }

}