import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        Random random = new Random();

        int numA = scanner.nextInt();
        int numB = scanner.nextInt();

        int numN = scanner.nextInt();
        int numK = scanner.nextInt();

        int min = numK;
        Map<Integer, Integer> seedToMaxMap= new TreeMap<>();
        for(int i = numA; i <= numB; i++) {
            random.setSeed(i);
//            System.out.println("seed = " + i);

            int max = 0;
            for(int j = 0; j < numN; j++) {
                int num = random.nextInt(numK);
                max = Math.max(max, num);
            }
            seedToMaxMap.put(i, max);
            min = Math.min(min, max);
//            System.out.println("max = " + max);
        }
        if(min == numK) {
            System.out.println("NO");
        } else {
            for(Map.Entry<Integer, Integer> entry : seedToMaxMap.entrySet()) {
                if(entry.getValue() == min) {
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                    break;
                }
            }
        }
    }
}