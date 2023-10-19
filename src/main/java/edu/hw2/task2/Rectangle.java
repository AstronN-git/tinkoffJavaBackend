package edu.hw2.task2;

// now rectangle's width and height are immutable
// and when trying to resize them returns new instance
public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        width = 0;
        height = 0;
    }

    public double area() {
        return width * height;
    }

    public Rectangle setWidth(int newWidth) {
        return new Rectangle(newWidth, height);
    }

    public Rectangle setHeight(int newHeight) {
        return new Rectangle(width, newHeight);
    }
}
