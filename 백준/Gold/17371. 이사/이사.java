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
        int N = Integer.parseInt(br.readLine());
        double[][] point = new double[N][2];
        double[] dist = new double[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Double.parseDouble(st.nextToken());
            point[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                dist[i] = Math.max(dist[i], Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2));
            }
        }

        int result = 0;
        for (int i = 1; i < N; i++) {
            if (dist[result] > dist[i]) result = i;
        }

        bw.write(point[result][0] + " " + point[result][1]);
        bw.flush();
        bw.close();
    }
}