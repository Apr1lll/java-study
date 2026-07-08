import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите число для проверки на палиндром: ");
        int number = scanner.nextInt();
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        
        if (original == reversed) {
            System.out.println(original + " - палиндром");
        } else {
            System.out.println(original + " - не палиндром");
        }
        
        scanner.close();
    }
}