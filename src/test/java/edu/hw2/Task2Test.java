package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
                Arguments.of(new Rectangle()),
                Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        Rectangle newRect = rect.setWidth(10).setHeight(20);

        assertEquals(200., newRect.area());
    }

    @Test
    void testRectangle() {
        var rectangle = new Rectangle(10, 140);
        assertEquals(1400., rectangle.area());

        rectangle = rectangle.setWidth(5);
        assertEquals(700., rectangle.area());
    }

    @Test
    void testSquare() {
        Rectangle square = new Square(10);
        assertEquals(100., square.area());

        square = square.setWidth(5);
        assertEquals(50., square.area());
    }
}
