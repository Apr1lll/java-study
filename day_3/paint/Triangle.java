package ru.vsu.paint;

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Point point, double sideA, double sideB, double sideC) {
        super(point);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    protected String getName() {
        return "Треугольник";
    }
}
