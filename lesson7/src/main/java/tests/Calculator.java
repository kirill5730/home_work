package tests;

public class Calculator {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int add(int a, int b) { return a + b; }
    public static int subtract(int a, int b) { return a - b; }
    public static int multiply(int a, int b) { return a * b; }

    public static int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("division by zero");
        return a / b;
    }

    public static String compare(int a, int b) {
        if (a > b) return "greater";
        if (a < b) return "less";
        return "equal";
    }
}