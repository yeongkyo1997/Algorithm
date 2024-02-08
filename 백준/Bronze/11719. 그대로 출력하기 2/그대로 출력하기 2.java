import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String s;
        while ((s = br.readLine()) != null) {
            bw.write(s + "\n");
        }
        bw.close();
    }
}