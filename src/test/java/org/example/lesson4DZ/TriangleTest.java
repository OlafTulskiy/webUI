package org.example.lesson4DZ;

import DZ4.MyException;
import DZ4.Triangle;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {

    @Test
    public void positiveTest() throws MyException {
        Triangle clasTriangle = new Triangle();
        Assertions.assertEquals(9.921567416492215,clasTriangle.AreaOfTriangle(4,5,6));
    }

    @Test
    public void testOnNegativeSideTest() throws MyException {
        Triangle clasTriangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> clasTriangle.AreaOfTriangle(-4,5,6));
    }

    @Test
    public void testOnNullSideTest() throws MyException {
        Triangle clasTriangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> clasTriangle.AreaOfTriangle(4,0,6));
    }

    @Test
    public void IsTriangleExictTest() throws MyException {
        Triangle clasTriangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> clasTriangle.AreaOfTriangle(4,5,100));
    }

    @ParameterizedTest
    @CsvSource("7,8,9, 26.832815729997478")
    public void positiveTestWithScvSource (int a, int b, int c, double result) throws MyException {
        Triangle clasTriangle = new Triangle();
        Assertions.assertEquals(result,clasTriangle.AreaOfTriangle(a,b,c));

    }
}
