package maths;

/**
 * @author https://github.com/shellhub
 */
public class FactorialRecursion {
    public static void main(String[] args) {
        assert factorial(0) == 1;
        assert factorial(1) == 1;
        assert factorial(3) == 6;
        assert factorial(5) == 120;
    }

    /**
     * calculate factorial using recursion
     *
     * @param n the number
     * @return the factorial of {@code n}
     */
    public static long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + " < 0");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
