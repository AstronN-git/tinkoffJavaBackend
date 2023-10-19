package edu.hw2;

import edu.hw2.task1.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void testConstant() {
        Expr a = new Constant(3);
        assertEquals(3.0, a.evaluate(), 0.00001);

        Expr b = new Constant(-991.5);
        assertEquals(-991.5, b.evaluate(), 0.00001);
    }

    @Test
    void testNegate() {
        Expr a = new Constant(3);
        Expr aNeg = new Negate(a);

        assertEquals(-3.0, aNeg.evaluate(), 0.00001);

        Expr b = new Constant(0);
        Expr bNeg = new Negate(b);

        assertEquals(0, bNeg.evaluate(), 0.00001);

        Expr c = new Addition(a, new Constant(-5));
        Expr cNeg = new Negate(c);

        assertEquals(2.0, cNeg.evaluate(), 0.00001);
    }

    @Test
    void testAddition() {
        Expr a = new Constant(19);
        Expr b = new Negate(new Constant(4));

        assertEquals(15.0, new Addition(a, b).evaluate(), 0.00001);

        Expr c = new Addition(a, new Constant(15.0));

        assertEquals(53.0, new Addition(a, c).evaluate(), 0.00001);

        Expr d = new Multiplication(a, new Constant(3));

        assertEquals(91.0, new Addition(c, d).evaluate(), 0.00001);
    }

    @Test
    void testMultiplication() {
        Expr a = new Constant(5);
        Expr b = new Constant(7.5);

        assertEquals(37.5, new Multiplication(a, b).evaluate(), 0.00001);

        Expr c = new Addition(a, b);

        assertEquals(62.5, new Multiplication(a, c).evaluate(), 0.00001);

        Expr d = new Negate(b);

        assertEquals(-37.5, new Multiplication(a, d).evaluate(), 0.00001);
    }

    @Test
    void testExponent() {
        Expr two = new Constant(2);

        assertEquals(8.0, new Exponent(two, 3).evaluate(), 0.00001);

        Expr negThree = new Negate(new Constant(3));

        assertEquals(9.0, new Exponent(negThree, 2).evaluate(), 0.00001);
    }

    @Test
    void testAllAtOnce() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        // (((2 + 4) * (-1)) ^ 2) + 1 = -6 ^ 2 + 1 = 37
        assertEquals(37.0, res.evaluate(), 0.00001);
    }
}
