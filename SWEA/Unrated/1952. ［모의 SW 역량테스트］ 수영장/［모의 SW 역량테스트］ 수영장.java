import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] price = new int[4]; // 1일, 1달, 3달, 1년
    static int[] plan = new int[12]; // 1월부터 12월까지
    static int min_price = 99999999; // 최소 가격

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 12; i++) { // 1월부터 12월까지
                plan[i] = Integer.parseInt(st.nextToken());
            }

            min_price = 99999999; // 최소 가격 초기화
            swim(0, 0); // 1월부터 시작

            bw.write("#" + (t + 1) + " " + min_price + "\n");
        }
        bw.close();
    }

    static void swim(int idx, int money) {
        if (idx >= 12) { // 12월까지 계산했으면
            if (money < min_price) { // 최소 가격보다 작으면
                min_price = money; // 최소 가격 갱신
            }
            return;
        }

        if (plan[idx] != 0) { // 이용할 수 있는 달이면
            for (int i = 0; i < 4; i++) { // 1일, 1달, 3달, 1년
                if (i == 0) {
                    swim(idx + 1, money + price[i] * plan[idx]); // 1일
                } else if (i == 1) {
                    swim(idx + 1, money + price[i]); // 1달
                } else if (i == 2) {
                    swim(idx + 3, money + price[i]); // 3달
                } else {
                    swim(idx + 12, money + price[i]); // 1년
                }
            }
        } else {
            swim(idx + 1, money); // 이용할 수 없는 달이면 다음 달로
        }
    }
}