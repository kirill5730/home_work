package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void testFactorial() {
        assertEquals(1L, Calculator.factorial(0));
        assertEquals(1L, Calculator.factorial(1));
        assertEquals(6L, Calculator.factorial(3));
        assertEquals(120L, Calculator.factorial(5));
    }

    @Test
    public void testAdd() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, Calculator.subtract(2, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, Calculator.multiply(2, 3));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(1, 0));
    }

    @Test
    public void testCompare() {
        assertEquals("greater", Calculator.compare(3, 2));
        assertEquals("less", Calculator.compare(2, 3));
        assertEquals("equal", Calculator.compare(5, 5));
    }
}