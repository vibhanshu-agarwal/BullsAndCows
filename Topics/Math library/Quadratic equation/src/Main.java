import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
//        x = (-b ± sqrt(b^2 - 4ac)) / 2a
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            if (x1 > x2) {
                System.out.println(x2 + " " + x1);
            } else {
                System.out.println(x1 + " " + x2);
            }
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        }
    }
}