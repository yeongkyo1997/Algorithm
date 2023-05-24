import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6553_Diplomatic_License {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int[][] coordinates = new int[n][2];
            for (int i = 0; i < n; i++) {
                coordinates[i][0] = Integer.parseInt(st.nextToken());
                coordinates[i][1] = Integer.parseInt(st.nextToken());
            }

            System.out.print(n + " ");
            for (int i = 0; i < n; i++) {
                int x1 = coordinates[i][0];
                int y1 = coordinates[i][1];
                int x2 = coordinates[(i + 1) % n][0];
                int y2 = coordinates[(i + 1) % n][1];

                double meetingX = (x1 + x2) / 2.0;
                double meetingY = (y1 + y2) / 2.0;

                System.out.printf("%.6f %.6f%n", meetingX, meetingY);
            }
        }
    }
}
