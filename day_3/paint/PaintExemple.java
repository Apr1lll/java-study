package ru.vsu.paint;

public class PaintExemple {

    public static void main(String[] args) {
        Circle circle = new Circle(new Point(0, 0), 5);
        Rectangle rectangle = new Rectangle(new Point(1, 1), 4, 6);
        Square square = new Square(new Point(2, 2), 3);
        Triangle triangle = new Triangle(new Point(3, 3), 3, 4, 5);

        FigureUtil.draw(circle);
        FigureUtil.draw(rectangle, Color.RED);
        FigureUtil.draw(square, Color.GREEN);
        FigureUtil.draw(triangle, Color.BLUE);

        System.out.println("Площадь круга: " + FigureUtil.area(circle));
        System.out.println("Периметр круга: " + FigureUtil.perimeter(circle));

        System.out.println("Площадь прямоугольника: " + FigureUtil.area(rectangle));
        System.out.println("Периметр прямоугольника: " + FigureUtil.perimeter(rectangle));

        System.out.println("Площадь квадрата: " + FigureUtil.area(square));
        System.out.println("Периметр квадрата: " + FigureUtil.perimeter(square));

        System.out.println("Площадь треугольника: " + FigureUtil.area(triangle));
        System.out.println("Периметр треугольника: " + FigureUtil.perimeter(triangle));
    }
}
