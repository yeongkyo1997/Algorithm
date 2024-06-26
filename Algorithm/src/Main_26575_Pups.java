import java.io.*;
import java.util.StringTokenizer;

public class Main_26575_Pups {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        double dog = 0;
        double food = 0;
        double price = 0;

        double sum;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dog = Double.parseDouble(st.nextToken());
            food = Double.parseDouble(st.nextToken());
            price = Double.parseDouble(st.nextToken());
            sum = dog * food * price;
            bw.write(String.format("$%.2f", sum) + "\n");
        }

        bw.close();
    }
}
