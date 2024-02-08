import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && i % 10 == 0) {
                bw.write("\n");
            }
            bw.write(str.charAt(i) + "");
        }
        bw.close();
    }
}