package ru.vsu.paint;

public abstract class Figure implements Drawable {
    protected Point point;

    public Figure(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public abstract double area();

    public abstract double perimeter();

    protected abstract String getName();

    @Override
    public void draw() {
        draw(Color.BLACK);
    }

    @Override
    public void draw(Color color) {
        System.out.println("Нарисован(а) " + getName() + " с координатами " + point
                + " цветом " + color);
    }
}
