import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите натуральное число (не более 100): ");
        int decimal = scanner.nextInt();
        
        if (decimal <= 0 || decimal > 100) {
            System.out.println("Число должно быть от 1 до 100");
        } else {
            String[] thousands = {"", "M"};
            String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            
            String roman = thousands[decimal / 1000] +
                          hundreds[(decimal % 1000) / 100] +
                          tens[(decimal % 100) / 10] +
                          ones[decimal % 10];
            
            System.out.println(decimal + " в римской записи: " + roman);
        }
        
        scanner.close();
    }
}