# Примеры нарушения принципов SOLID на языке Java

Необходимо определить, какой принцип SOLID нарушен, исправить и в методе main показать использование исправленного варианта.



### Пример 1 – нарушение SRP (Single Responsibility Principle)

Класс UserLogger занимается и хранением пользователей, и аутентификацией, и логированием. Нужно разделить ответственности.

```java
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// 1. Отвечает только за хранение и аутентификацию пользователей
class UserRepository {
    private Map<String, String> users = new HashMap<>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

// 2. Отвечает только за логирование
class Logger {
    public void log(String message) {
        System.out.println("[" + LocalDateTime.now() + "] " + message);
    }

    public void logError(String error) {
        System.err.println("[ERROR " + LocalDateTime.now() + "] " + error);
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        Logger logger = new Logger();

        repo.addUser("alice", "1234");
        logger.log("Пользователь добавлен");

        boolean ok = repo.authenticate("alice", "1234");
        logger.log("Аутентификация: " + ok);

        if (!repo.authenticate("alice", "wrong")) {
            logger.logError("Ошибка аутентификации");
        }
    }
}
```

### Пример 2 – нарушение OCP (Open/Closed Principle)

Класс ShapeAreaCalculator использует instanceof и условные операторы. При добавлении новой фигуры придётся менять код. Нужно сделать фигуры полиморфными.

```java
// Базовый класс/интерфейс
abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Калькулятор теперь не требует изменений при добавлении новых фигур
class ShapeAreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        ShapeAreaCalculator calculator = new ShapeAreaCalculator();

        Shape circle = new Circle(5);
        Shape rect = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);

        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println("Rectangle area: " + calculator.calculateArea(rect));
        System.out.println("Triangle area: " + calculator.calculateArea(triangle));
    }
}
```

### Пример 3 – нарушение LSP (Liskov Substitution Principle)

Класс SquareLSP наследует RectangleLSP и изменяет поведение методов setWidth/setHeight. Это приводит к тому, что код, ожидающий прямоугольник, некорректно работает с квадратом (нарушается контракт). Решение – не использовать наследование, если поведение не совместимо.

```java
interface Shape {
    int getArea();
}

class RectangleLSP implements Shape {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class SquareLSP implements Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        RectangleLSP rect = new RectangleLSP();
        rect.setWidth(4);
        rect.setHeight(5);
        System.out.println("Rectangle area: " + rect.getArea());

        SquareLSP square = new SquareLSP();
        square.setSide(4);
        System.out.println("Square area: " + square.getArea());

        // Теперь мы не подменяем прямоугольник квадратом,
        // и код работает корректно.
    }
}
```

### Пример 4 – нарушение ISP (Interface Segregation Principle)

Интерфейс Worker содержит два метода – work() и eat(). Но роботы не едят, поэтому они вынуждены бросать исключение. Нужно разделить интерфейсы.

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Человек работает");
    }

    @Override
    public void eat() {
        System.out.println("Человек ест");
    }
}

class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Робот работает");
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        Workable humanWorker = new Human();
        Workable robotWorker = new Robot();

        humanWorker.work();
        ((Eatable) humanWorker).eat(); // безопасно

        robotWorker.work();
        // робот не имеет метода eat() – интерфейс не перегружен
    }
}
```


### Пример 5 – нарушение DIP (Dependency Inversion Principle)

Класс UserServiceDIPViolation жёстко зависит от конкретной реализации MySQLDatabase. Нужно ввести абстракцию (интерфейс) и внедрять зависимость через конструктор.

```java
// Абстракция
interface Database {
    void save(String data);
}

// Конкретная реализация
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Сохранение в MySQL: " + data);
    }
}

// Другая реализация (например, для тестов)
class InMemoryDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Сохранение в памяти: " + data);
    }
}

// Сервис зависит от абстракции, а не от конкретной БД
class UserServiceDIPViolation {
    private Database database;

    // Внедрение зависимости через конструктор
    public UserServiceDIPViolation(Database database) {
        this.database = database;
    }

    public void createUser(String username) {
        database.save("User: " + username);
    }
}

// Демонстрация
public class Main {
    public static void main(String[] args) {
        Database mySQL = new MySQLDatabase();
        UserServiceDIPViolation service1 = new UserServiceDIPViolation(mySQL);
        service1.createUser("alice");

        Database inMemory = new InMemoryDatabase();
        UserServiceDIPViolation service2 = new UserServiceDIPViolation(inMemory);
        service2.createUser("bob");
    }
}
```