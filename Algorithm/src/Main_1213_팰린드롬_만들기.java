import java.util.*;

public class Main_1213_팰린드롬_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        char center = ' ';
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                if (center != ' ') {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                center = (char) (i + 'A');
            }
            for (int j = 0; j < cnt[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }
        String left = sb.toString();
        String right = sb.reverse().toString();
        if (center != ' ') {
            sb.append(center);
        }
        sb.append(right);
        sb.append(left);
        System.out.println(sb.toString());
    }
}
