import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int year;
        int[] arr = new int[10];
        char[] ch = new char[12];

        IntStream.range(0, 10).forEach(i -> arr[i] = i);
        IntStream.range(0, 12).forEach(i -> ch[i] = (char) (i + 65));

        year = Integer.parseInt(br.readLine());
        bw.write(ch[((year + 8) % 12)] + String.valueOf(arr[(year + 6) % 10]));
        bw.close();
    }
}