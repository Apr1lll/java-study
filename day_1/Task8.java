import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char secret = (char) ('A' + (int) (Math.random() * 26));
        System.out.println("Игра: угадайте букву от A до Z");
        
        while (true) {
            System.out.print("Введите букву: ");
            char guess = scanner.next().toUpperCase().charAt(0);
            
            if (guess == secret) {
                System.out.println("Right!");
                break;
            } else if (guess < secret) {
                System.out.println("You're too low");
            } else {
                System.out.println("You're too high");
            }
        }
        
        scanner.close();
    }
}