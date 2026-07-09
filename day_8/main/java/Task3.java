import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

class Order {
    private int id;
    private double amount;
    private LocalDate date;

    public Order(int id, double amount, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return String.format("Order{id=%d, amount=%.2f, date=%s}", id, amount, date);
    }
}

public class Task3 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order(1, 150.50, LocalDate.of(2024, Month.JANUARY, 15)),
            new Order(2, 200.00, LocalDate.of(2024, Month.JANUARY, 20)),
            new Order(3, 75.25, LocalDate.of(2024, Month.FEBRUARY, 5)),
            new Order(4, 300.75, LocalDate.of(2024, Month.FEBRUARY, 10)),
            new Order(5, 100.00, LocalDate.of(2024, Month.MARCH, 1)),
            new Order(6, 250.50, LocalDate.of(2024, Month.MARCH, 15)),
            new Order(7, 50.00, LocalDate.of(2024, Month.JANUARY, 25))
        );

        Optional<Order> maxOrder = orders.stream()
            .max(Comparator.comparingDouble(Order::getAmount));
        
        Optional<Order> minOrder = orders.stream()
            .min(Comparator.comparingDouble(Order::getAmount));

        int targetYear = 2024;
        Month targetMonth = Month.JANUARY;
        double totalForMonth = orders.stream()
            .filter(order -> order.getDate().getYear() == targetYear 
                    && order.getDate().getMonth() == targetMonth)
            .mapToDouble(Order::getAmount)
            .sum();

        maxOrder.ifPresent(order -> 
            System.out.printf("Заказ с максимальной суммой: %s (сумма: %.2f)%n", 
                order, order.getAmount())
        );

        minOrder.ifPresent(order -> 
            System.out.printf("Заказ с минимальной суммой: %s (сумма: %.2f)%n", 
                order, order.getAmount())
        );

        System.out.printf("Общая сумма заказов за %s %d: %.2f%n", 
            targetMonth, targetYear, totalForMonth);
    }
}