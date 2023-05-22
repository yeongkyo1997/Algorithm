package A형_역테_그리디;

import java.io.*;
import java.util.*;

public class Main_1339_단어_수학 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int[] len = new int[n];
        int[] alpha = new int[26];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            len[i] = arr[i].length();
        }

        for (int i = 0; i < n; i++) { // 알파벳에 대한 가중치 계산
            int cal = 1; // 자릿수
            for (int j = len[i] - 1; j >= 0; j--) { // 자릿수에 대한 가중치 계산
                alpha[arr[i].charAt(j) - 'A'] += cal;
                cal *= 10; // 자릿수 증가
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i : alpha) { // 가중치에 대한 내림차순 정렬
            list.add(i);
        }

        Integer[] alphaInteger = list.toArray(new Integer[0]); // Integer 배열로 변환
        Arrays.sort(alphaInteger, Comparator.reverseOrder()); // 내림차순 정렬

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += alphaInteger[i] * (9 - i); // 가중치 * 9부터 0까지
        }

        bw.write(result + "\n");
        bw.close();
    }
}