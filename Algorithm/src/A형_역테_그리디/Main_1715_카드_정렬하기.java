package A형_역테_그리디;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1715_카드_정렬하기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cards = new PriorityQueue<>(); // 우선순위 큐

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        if (cards.size() == 1) { // 카드가 한장일 경우
            bw.write(result + "\n");
        } else {
            for (int i = 0; i < n - 1; i++) { // 카드가 한장 이상일 경우
                int previous = cards.poll(); // 가장 작은 카드
                int current = cards.poll(); // 두번째로 작은 카드

                result += previous + current; // 비교 횟수 누적
                cards.add(previous + current); // 두 카드를 더한 값을 다시 넣어줌
            }
            bw.write(result + "\n");
        }
        bw.close();
    }
}
