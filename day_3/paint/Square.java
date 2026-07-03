package ru.vsu.paint;

public class Square extends Rectangle {

    public Square(Point point, double side) {
        super(point, side, side);
    }

    @Override
    protected String getName() {
        return "Квадрат";
    }
}
