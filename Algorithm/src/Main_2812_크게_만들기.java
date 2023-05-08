import java.util.*;

public class Main_2812_크게_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String num = sc.next();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        sb.setLength(n - k);
        System.out.println(sb.toString());
    }
}
