package task_2;
class Circle {
    private double radius;
    private String color;
    
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }
    
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public String getColor() {
        return color;
    }
    
    @Override
    public String toString() {
        return String.format("Круг: радиус = %.2f, цвет = %s, площадь = %.2f, периметр = %.2f",
                           radius, color, area(), perimeter());
    }
}

public class Task2 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0, "Красный");
        Circle circle2 = new Circle(3.5, "Синий");
        Circle circle3 = new Circle(7.2, "Зеленый");
        
        System.out.println("Информация о кругах:");
        System.out.println("1. " + circle1);
        System.out.println("2. " + circle2);
        System.out.println("3. " + circle3);
        
        System.out.println("\nДемонстрация отдельных методов:");
        
        System.out.printf("Круг 1: радиус = %.2f, площадь = %.2f, периметр = %.2f%n",
                         circle1.getRadius(), circle1.area(), circle1.perimeter());
        System.out.printf("Круг 2: радиус = %.2f, площадь = %.2f, периметр = %.2f%n",
                         circle2.getRadius(), circle2.area(), circle2.perimeter());
        System.out.printf("Круг 3: радиус = %.2f, площадь = %.2f, периметр = %.2f%n",
                         circle3.getRadius(), circle3.area(), circle3.perimeter());
        
        Circle circle4 = new Circle(10.0, "Желтый");
        System.out.println("\nДополнительный круг: " + circle4);
    }
}