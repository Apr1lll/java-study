import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите трёхзначное число: ");
        int n = scanner.nextInt();
        
        int digit1 = n / 100;
        int digit2 = (n / 10) % 10;
        int digit3 = n % 10;
        int sum = digit1 + digit2 + digit3;
        
        System.out.println("Сумма цифр числа " + n + " = " + sum);
        
        scanner.close();
    }
}