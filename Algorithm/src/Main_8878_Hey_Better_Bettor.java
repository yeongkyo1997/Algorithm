import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_8878_Hey_Better_Bettor {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static double x;
    private static double p;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken()) / 100;
        p = Double.parseDouble(st.nextToken()) / 100;
        double best = 1;
        double result = 0;

        double win;
        double loss = 1;
        if (p != 0) {
            while (true) {
                double pre = 0;
                boolean flag = false;

                win = best;

                while (true) {
                    double cur = solve(win, loss);
                    if (cur > result) {
                        result = cur;
                        best = win;
                        flag = true;
                    }

                    if (cur < pre) {
                        break;
                    }
                    pre = cur;
                    win += 1;
                }

                if (!flag) break;
                loss += 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static double solve(double W, double L) {
        double r = (1 - p) / p;

        double rW = Math.pow(r, W);
        double rL = Math.pow(r, -L);

        double p0 = (1 - rL) / (rW - rL);
        return W * p0 - (1 - x) * L * (1 - p0);
    }
}
