import java.util.Scanner;
import java.util.stream.IntStream;


public class Main {

    static char[] a = new char[20];
    static int n;
    static int k;


    public static int getRecNumber(char[] a, int k) {
        int mask = 0;
        for (int i = 0; i <= k; i++) {
            if (a[i] != '*') {
                mask |= (1 << (a[i] - '0'));
            }
        }
        return mask;
    }

    public static int getMinWithMask(char[] a, int k) {
        int mask = getRecNumber(a, k);
        return IntStream.rangeClosed(0, 9).filter(i -> (mask & (1 << i)) != 0).findFirst().orElse(0);
    }

    public static int getMinWithoutMask(char[] a, int k, int base) {
        int mask = getRecNumber(a, k);
        return IntStream.rangeClosed(base - '0' + 1, 9).filter(i -> (~mask & (1 << i)) != 0).findFirst().orElse(-1);
    }

    public static int checkSuccess(char[] a, int k, int base) {
        int mask = getRecNumber(a, k);
        return IntStream.rangeClosed(base - '0' + 1, 9).filter(i -> (mask & (1 << i)) != 0).findFirst().orElse(-1);
    }

    public static int getKnumber(int mask) {
        int res = (int) IntStream.rangeClosed(0, 9).filter(i -> (mask & (1 << i)) != 0).count();
        return res;
    }

    public static void recul(int cur) {
        int myk;
        if (cur == 0) {
            a[0] = '1';
            return;
        }

        if (a[cur] != '*') {
            myk = getKnumber(getRecNumber(a, cur - 1));
            if (myk == k) {
                int val = checkSuccess(a, cur - 1, a[cur]);
                if (val > 0) {
                    a[cur] = (char) (val + '0');
                    return;
                }
            } else if (myk < k) {
                if (a[cur] != '9' && n - cur + 1 >= (k - myk)) {
                    if (n - cur + 1 > (k - myk)) {
                        a[cur] = (char) (a[cur] + 1);
                        return;
                    } else {
                        a[cur] = (char) (getMinWithoutMask(a, cur - 1, a[cur]) + '0');
                        if (a[cur] != '0' - 1) {
                            return;
                        }
                    }
                }
            }

        }
        recul(cur - 1);

        myk = getKnumber(getRecNumber(a, cur - 1));
        if (n - cur + 1 > (k - myk) && (k - myk) != 0) {
            a[cur] = '0';
        } else if (k - myk == 0) {
            a[cur] = (char) (getMinWithMask(a, cur - 1) + '0');
        } else {
            a[cur] = (char) (getMinWithoutMask(a, cur - 1, '0' - 1) + '0');
        }
    }

    public static void main(String[] args) {
        a[0] = '*';
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        k = sc.nextInt();
        IntStream.range(0, input.length()).forEach(i -> a[i + 1] = input.charAt(i));

        n = input.length();

        if (n < k) {
            IntStream.rangeClosed(1, n).forEach(i -> a[i + (k - n - 1)] = a[i]);
            IntStream.rangeClosed(1, (k - n - 1)).forEach(i -> a[i] = '*');
            n = k - 1;
        }
        int myk = getKnumber(getRecNumber(a, n));
        if (myk == k) {
            System.out.println(String.valueOf(a, 1, n));
            return;
        }
        recul(n);
        System.out.println(a[0] == '*' ? String.valueOf(a, 1, n) : String.valueOf(a, 0, n + 1));
    }

}