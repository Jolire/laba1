package test.demo.parallel;

import demo.parallel.Complex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ComplexOperationsTest {
    private static final double EPSILON = 1e-9;

    @Test
    public void testSubtract() {
        // Create test complex numbers
        Complex a = new Complex(5.0, 3.0);
        Complex b = new Complex(2.0, 4.0);

        // Perform subtraction: (5 + 3i) - (2 + 4i) = (3 - i)
        Complex result = a.subtract(b);

        // Verify the result is the same object (method chaining)
        assertEquals(a, result);

        // Verify the result values using toString() since there are no getters
        assertEquals("3.0 + -1.0i", result.toString());

        // Additional verification by checking the operation in reverse
        Complex c = new Complex(2.0, 3.0);
        Complex d = new Complex(5.0, 7.0);
        c.subtract(d); // (2 + 3i) - (5 + 7i) = (-3 - 4i)
        assertEquals("-3.0 + -4.0i", c.toString());
    }

    @Test
    public void testDivide() {
        // Create test complex numbers
        Complex a = new Complex(4.0, 2.0);
        Complex b = new Complex(1.0, -1.0);

        // Perform division: (4 + 2i) / (1 - i) = (1 + 3i)
        Complex result = a.divide(b);

        // Verify the result is the same object (method chaining)
        assertEquals(a, result);

        // Verify the result values using toString()
        assertEquals("1.0 + 3.0i", result.toString());

        // Test division by a real number: (6 + 9i) / (3 + 0i) = (2 + 3i)
        Complex c = new Complex(6.0, 9.0);
        Complex d = new Complex(3.0, 0.0);
        c.divide(d);
        assertEquals("2.0 + 3.0i", c.toString());

        // Test division that results in real number only: (4 + 0i) / (2 + 0i) = (2 + 0i)
        Complex e = new Complex(4.0, 0.0);
        Complex f = new Complex(2.0, 0.0);
        e.divide(f);
        assertEquals("2.0 + 0.0i", e.toString());
    }
}