import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Map<String, String> map = new HashMap<>();
        String a, b;

        for (int i = 0; i < N; i++) {
            a = scanner.next();
            b = scanner.next();

            map.put(a, b);
        }

        for (int i = 0; i < M; i++) {
            a = scanner.next();

            System.out.println(map.get(a));
        }
    }
}