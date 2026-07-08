import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите количество членов последовательности Фибоначчи (2 < n < 100): ");
        int n = scanner.nextInt();
        
        if (n > 2 && n < 100) {
            long fib1 = 0, fib2 = 1;
            System.out.print("Первые " + n + " чисел Фибоначчи: ");
            for (int i = 1; i <= n; i++) {
                System.out.print(fib1 + " ");
                long next = fib1 + fib2;
                fib1 = fib2;
                fib2 = next;
            }
            System.out.println();
        } else {
            System.out.println("Число должно быть в диапазоне (2, 100)");
        }
        
        scanner.close();
    }
}