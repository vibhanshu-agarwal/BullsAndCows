import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble(); // 2
        double y1 = scanner.nextDouble(); // 2
        double x2 = scanner.nextDouble(); // 0
        double y2 = scanner.nextDouble(); // 3

        double dotProduct = x1 * x2 + y1 * y2;
        double vectorLengthMultiple = Math.sqrt(Math.pow(x1,
                2) + Math.pow(y1,
                2)) * Math.sqrt(Math.pow(x2,
                2) + Math.pow(y2,
                2));
        double cos = dotProduct / vectorLengthMultiple;
        int angle = (int)Math.toDegrees(Math.acos(cos));

        System.out.println(angle);
    }
}