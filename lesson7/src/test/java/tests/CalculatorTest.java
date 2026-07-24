package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void testFactorial() {
        Assert.assertEquals(Calculator.factorial(0), 1L);
        Assert.assertEquals(Calculator.factorial(1), 1L);
        Assert.assertEquals(Calculator.factorial(3), 6L);
        Assert.assertEquals(Calculator.factorial(5), 120L);
    }

    @Test
    public void testArithmetic() {
        Assert.assertEquals(Calculator.add(2, 3), 5);
        Assert.assertEquals(Calculator.subtract(5, 2), 3);
        Assert.assertEquals(Calculator.multiply(4, 3), 12);
        // Твой divide возвращает int, поэтому сравниваем с int
        Assert.assertEquals(Calculator.divide(10, 2), 5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(1, 0);
    }

    @Test
    public void testCompare() {
        Assert.assertEquals(Calculator.compare(3, 2), "greater");
        Assert.assertEquals(Calculator.compare(2, 3), "less");
        Assert.assertEquals(Calculator.compare(5, 5), "equal");
    }
}