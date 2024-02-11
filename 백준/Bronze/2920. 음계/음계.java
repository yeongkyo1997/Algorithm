import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int[] arr = new int[8];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int status = -1;
        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1] && status != 1) {
                status = 0;
            } else if (arr[i] > arr[i + 1] && status != 0)
                status = 1;
            else {
                status = 2;
                break;
            }
        }
        switch (status) {
            case 0:
                bw.write("ascending");
                break;
            case 1:
                bw.write("descending");
                break;
            case 2:
                bw.write("mixed");
                break;
        }
        bw.close();
    }
}