import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static final MathContext MC = new MathContext(60);

    static final BigDecimal TWO = new BigDecimal("2", MC);
    static final BigDecimal ZERO = BigDecimal.ZERO;
    static final BigDecimal ONE = BigDecimal.ONE;

    static final BigDecimal PI = new BigDecimal(
            "3.141592653589793238462643383279502884197169399375105820974944592307816406286", MC);
    static final BigDecimal TWO_PI = PI.multiply(TWO, MC);

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigDecimal A = new BigDecimal(st.nextToken(), MC);
        BigDecimal B = new BigDecimal(st.nextToken(), MC);
        BigDecimal C = new BigDecimal(st.nextToken(), MC);

        BigDecimal low = ZERO;

        BigDecimal high = C.divide(A, MC).add(TWO_PI, MC);

        while (f(high, A, B, C).compareTo(ZERO) < 0) {
            high = high.multiply(TWO, MC);
        }

        for (int i = 0; i < 300; i++) {
            BigDecimal mid = low.add(high, MC).divide(TWO, MC);
            BigDecimal fMid = f(mid, A, B, C);
            if (fMid.compareTo(ZERO) < 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        BigDecimal result = low.add(high, MC).divide(TWO, MC);

        result = result.setScale(6, RoundingMode.HALF_UP);
        bw.write(result.toPlainString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    static BigDecimal f(BigDecimal x, BigDecimal A, BigDecimal B, BigDecimal C) {
        return A.multiply(x, MC)
                .add(B.multiply(sin(x, MC), MC), MC)
                .subtract(C, MC);
    }

    static BigDecimal sin(BigDecimal x, MathContext mc) {

        x = x.remainder(TWO_PI, mc);

        BigDecimal term = x;
        BigDecimal sum = x;
        BigDecimal x2 = x.multiply(x, mc);
        int n = 1;

        BigDecimal threshold = new BigDecimal("1E-50", mc);
        while (true) {

            BigDecimal denominator = new BigDecimal(2L * n * (2L * n + 1), mc);
            term = term.multiply(x2, mc).divide(denominator, mc).negate();
            sum = sum.add(term, mc);
            if (term.abs().compareTo(threshold) < 0)
                break;
            n++;
        }
        return sum;
    }
}