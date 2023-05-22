package A형_역테_그리디;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1744_수_묶기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int result = 0;
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        int n= Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input= Integer.parseInt(br.readLine());
            if (input > 0) positive.add(input);
            else negative.add(input);
        }

        positive.sort(Collections.reverseOrder()); // 내림차순 정렬
        Collections.sort(negative); // 오름차순 정렬

        for (int i = 1; i < positive.size(); i += 2) {
            if (positive.get(i) == 1 || positive.get(i - 1) == 1) { // 1이 있으면 더하는게 더 큼
                result += (positive.get(i - 1) + positive.get(i));
            } else { // 1이 없으면 곱하는게 더 큼
                result += (positive.get(i - 1) * positive.get(i));
            }
        }
        if (positive.size() % 2 != 0) { // 홀수개면 마지막 값 더해줌
            result += positive.get(positive.size() - 1);
        }

        for (int i = 1; i < negative.size(); i += 2) { // 음수도 같은 방식으로, 0이 있으면 곱하는게 더 큼
            result += (negative.get(i - 1) * negative.get(i));
        }
        if (negative.size() % 2 != 0) { // 홀수개면 마지막 값 더해줌, 0이 있으면 곱하는게 더 큼
            result += negative.get(negative.size() - 1);
        }

        bw.write(result + "\n");
    }
}
