import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_15904_UCPC는_무엇의_약자일까 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {


        String str = br.readLine();


        int n1, n2, n3, n4;

        n1 = str.indexOf('U');
        n2 = str.indexOf('C', n1);
        n3 = str.indexOf('P', n2);
        n4 = str.indexOf('C', n3);


        bw.write(n1 == -1 || n2 == -1 || n3 == -1 || n4 == -1 ? "I hate UCPC" : "I love UCPC");
        bw.close();
    }
}
