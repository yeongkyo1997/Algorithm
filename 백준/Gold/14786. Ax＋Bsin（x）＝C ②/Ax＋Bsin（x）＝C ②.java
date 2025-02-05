import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        double low = 0.0, high = C / A + 2 * Math.PI;
        double mid, f;

        for (int i = 0; i < 100000; i++) {
            mid = (low + high) / 2.0;
            f = A * mid + B * Math.sin(mid);
            if (f < C) {
                low = mid;
            } else {
                high = mid;
            }
        }

        double x = (low + high) / 2.0;

        bw.write(String.format("%.10f", x));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}