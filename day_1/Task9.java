import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Решение квадратного уравнения ax² + bx + c = 0");
        System.out.print("Введите a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите c: ");
        double c = scanner.nextDouble();
        
        if (Math.abs(a) < 1e-10) {
            System.out.println("Это не квадратное уравнение (a = 0)");
        } else {
            double discriminant = b * b - 4 * a * c;
            
            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.printf("Корни: x1 = %.2f, x2 = %.2f\n", x1, x2);
            } else if (Math.abs(discriminant) < 1e-10) {
                double x = -b / (2 * a);
                System.out.printf("Один корень (дискриминант = 0): x = %.2f\n", x);
            } else {
                System.out.println("Корней нет (дискриминант < 0)");
            }
        }
        
        scanner.close();
    }
}