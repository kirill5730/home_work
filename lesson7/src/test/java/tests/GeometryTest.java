package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeometryTest {

    @Test
    public void testTriangleAreaValid() {
        // Треугольник 3-4-5: площадь 6.0
        Assert.assertEquals(Geometry.triangleArea(3, 4, 5), 6.0, 0.001);

        // Равносторонний треугольник со стороной 2: площадь ≈ 1.732
        Assert.assertEquals(Geometry.triangleArea(2, 2, 2), 1.7320508075688772, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaNegativeSide() {
        Geometry.triangleArea(-3, 4, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaInvalid() {
        // Это не треугольник: 1+2 <= 3
        Geometry.triangleArea(1, 2, 3);
    }
}