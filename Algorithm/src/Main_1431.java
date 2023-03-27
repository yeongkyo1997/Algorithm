import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1431 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N];

        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }
    }
}
