import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_4149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BigInteger N = new BigInteger(br.readLine());
        factorization(N);
        bw.close();

    }

    // 밀러-라빈 소수 판별을 이용한 소인수분해
    public static void factorization(BigInteger n) throws IOException {

    }

    // 밀러-라빈 소수 판별
    public static boolean millerRabin(BigInteger n, BigInteger k) {
        if (n.equals(BigInteger.valueOf(2))) {
            return true;
        }
        if (n.equals(BigInteger.ONE) || n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            return false;
        }

        BigInteger d = n.subtract(BigInteger.ONE);
        BigInteger s = BigInteger.ZERO;
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.valueOf(2));
            s = s.add(BigInteger.ONE);
        }

        for (int i = 0; i < k.intValue(); i++) {
            BigInteger a = randomBigInteger(BigInteger.valueOf(2), n.subtract(BigInteger.ONE));
            BigInteger x = a.modPow(d, n);
            if (!x.equals(BigInteger.ONE) && !x.equals(n.subtract(BigInteger.ONE))) {
                for (int j = 0; j < s.intValue() - 1; j++) {
                    x = x.modPow(BigInteger.valueOf(2), n);
                    if (x.equals(BigInteger.ONE)) return false;
                    if (x.equals(n.subtract(BigInteger.ONE))) break;
                }
                if (!x.equals(n.subtract(BigInteger.ONE))) return false;
            }
        }
        return true;
    }

    // 랜덤한 BigInteger 생성
    public static BigInteger randomBigInteger(BigInteger min, BigInteger max) {
        BigInteger result = new BigInteger(max.bitLength(), new java.util.Random());

        while (result.compareTo(min) < 0 || result.compareTo(max) > 0) {
            result = new BigInteger(max.bitLength(), new java.util.Random());
        }
        return result;
    }
}