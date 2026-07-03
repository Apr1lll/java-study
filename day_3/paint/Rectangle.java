package ru.vsu.paint;

public class Rectangle extends Figure {
    protected double width;
    protected double height;

    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    protected String getName() {
        return "Прямоугольник";
    }
}
