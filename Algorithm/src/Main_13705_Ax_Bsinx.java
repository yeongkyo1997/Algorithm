import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.StringTokenizer;

public class Main_13705_Ax_Bsinx {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static BigDecimal A, B, C;
    static BigDecimal pi = new BigDecimal("3.14159265358979323846264338327950288419716939937510582097");

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        A = new BigDecimal(st.nextToken());
        B = new BigDecimal(st.nextToken());
        C = new BigDecimal(st.nextToken());
        bw.write(solve(A, B, C).setScale(6, BigDecimal.ROUND_HALF_UP).toString());
        bw.close();
    }

    static BigDecimal solve(BigDecimal A, BigDecimal B, BigDecimal C) {
        BigDecimal left = BigDecimal.ZERO;
        BigDecimal right = BigDecimal.valueOf(100000);
        BigDecimal mid = BigDecimal.ZERO;

        int n = 100;

        while (n-- > 0) {
            mid = left.add(right).divide(BigDecimal.valueOf(2));
            BigDecimal res = A.multiply(mid).add(B.multiply(sin(mid)));
            if (res.compareTo(C) <= 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mid;
    }

    static BigDecimal sin(BigDecimal bd) {
        bd = bd.remainder(pi.multiply(new BigDecimal(2)));
        int n = 0;

        BigDecimal term = bd;
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal tmp = bd;
        BigDecimal one1 = BigDecimal.ONE;
        BigDecimal one2 = BigDecimal.ONE;

        while (n++ < 50) {
            zero = zero.add(one2.multiply(tmp.divide(one1, MathContext.DECIMAL128)));
            tmp = tmp.multiply(term).multiply(term);
            one1 = one1.multiply(new BigDecimal((2 * n) * (2 * n + 1)));
            one2 = one2.negate();
        }
        return zero;
    }
}