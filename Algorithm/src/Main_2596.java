import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_2596 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Map<Character, String> map = new HashMap<>();
        map.put('A', "000000");
        map.put('B', "001111");
        map.put('C', "010011");
        map.put('D', "011100");
        map.put('E', "100110");
        map.put('F', "101001");
        map.put('G', "110101");
        map.put('H', "111010");

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] arr = IntStream.range(0, 8).mapToObj(j -> map.get(str.charAt(j))).toArray(String[]::new);

            int[] result = new int[6];
            for (int j = 0; j < 6; j++) {
                int sum = 0;
                for (int k = 0; k < 8; k++) sum += arr[k].charAt(j) - '0';

                result[j] = sum % 2;
            }

            for (int j = 0; j < 6; j++) {
                bw.write(result[j] + "");
            }
            bw.close();
        }
    }
}