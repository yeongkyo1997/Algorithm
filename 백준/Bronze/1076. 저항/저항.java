import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < color.length; i++) {
            if (A.equals(color[i])) a = i;
            if (B.equals(color[i])) b = i;
            if (C.equals(color[i])) c = i;
        }
        bw.write(String.valueOf((a * 10 + b) * (long) Math.pow(10, c)));
        bw.close();
    }
}