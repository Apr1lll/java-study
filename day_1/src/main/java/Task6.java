import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите натуральное число для проверки на простоту: ");
        int number = scanner.nextInt();
        
        boolean isPrime = true;
        
        if (number < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break; // выход при нахождении первого делителя
                }
            }
        }
        
        System.out.println(number + (isPrime ? " - простое" : " - составное"));
        
        scanner.close();
    }
}