import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        if (N == 0 || N == 1) {
            bw.write("1");
        } else {
            BigInteger result = multiplyRange(2, N);
            bw.write(result.toString());
        }
        bw.flush();
        bw.close();
    }
    
    private static BigInteger multiplyRange(int start, int end) {
        if (start == end) {
            return BigInteger.valueOf(start);
        }
        int mid = (start + end) >>> 1; // (start+end)/2 오버플로우 방지
        return multiplyRange(start, mid).multiply(multiplyRange(mid + 1, end));
    }
}