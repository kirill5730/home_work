package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeometryTest {

    @Test
    public void testTriangleAreaValid() {
        assertEquals(6.0, Geometry.triangleArea(3, 4, 5), 0.001);
    }

    @Test
    public void testTriangleAreaEquilateral() {
        double side = 2.0;
        double expected = Math.sqrt(3) * side * side / 4.0;
        assertEquals(expected, Geometry.triangleArea(side, side, side), 0.001);
    }

    @Test
    public void testTriangleAreaInvalidSides() {
        assertThrows(IllegalArgumentException.class, () -> Geometry.triangleArea(-1, 4, 5));
        assertThrows(IllegalArgumentException.class, () -> Geometry.triangleArea(1, 2, 10));
    }
}