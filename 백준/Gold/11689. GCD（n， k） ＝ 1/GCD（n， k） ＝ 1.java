import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long result = n;
        long temp = n;

        for (long i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {

                while (temp % i == 0) {
                    temp /= i;
                }

                result -= result / i;
            }
        }

        if (temp > 1) {
            result -= result / temp;
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}