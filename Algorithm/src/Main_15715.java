import java.util.Scanner;

public class Main_15715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        int[] cnt = new int[num + 1];
        int ans = 1;
        cnt[c[0]] = 1;
        for (int i = 1; i < n; i++) {
            int x = c[i];
            for (int j = 2; j * j <= x; j++) {
                if (x % j == 0) {
                    int k = 0;
                    while (x % j == 0) {
                        x /= j;
                        k++;
                    }
                    cnt[j] = (cnt[j] + k) % 1000000007;
                }
            }
            if (x > 1) {
                cnt[x] = (cnt[x] + 1) % 1000000007;
            }
            ans = (int) ((long) ans * (cnt[c[i]] + 1) % 1000000007);
        }
        System.out.println(ans);
    }
}
