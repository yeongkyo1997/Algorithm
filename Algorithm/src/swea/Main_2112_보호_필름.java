package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2112_보호_필름 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int D, W, K; // D: 두께, W: 가로길이, K: 합격기준
    static boolean[][] film = new boolean[13][20]; // 보호필름
    static boolean[][] film_copy = new boolean[13][20]; // 보호필름 복사본
    static ArrayList<Pair> change = new ArrayList<>(); // 약품을 투입할 위치와 약품 종류를 저장할 리스트

    static boolean inspect() { // 검사
        for (int i = 0; i < W; i++) {
            int cur = film[0][i] ? 1 : 0; // 현재 검사하는 세로줄의 값
            int cnt = 1; // 현재 검사하는 세로줄의 연속된 값의 개수

            for (int j = 1; j < D; j++) { // 세로줄 검사
                if (cnt == K) break; // 연속된 값의 개수가 K개이면 다음 세로줄 검사
                if (cur == (film[j][i] ? 1 : 0)) cnt++;  // 현재 검사하는 세로줄의 값이 이전 검사한 세로줄의 값과 같으면 cnt++
                else {
                    cur = film[j][i] ? 1 : 0; // 현재 검사하는 세로줄의 값이 이전 검사한 세로줄의 값과 다르면 now값 변경
                    cnt = 1; // 연속된 값의 개수 초기화
                }
            }
            if (cnt < K) return false;
        }
        return true;
    }

    /*
     * start: 약품을 투입할 위치
     * k: 약품을 투입할 개수
     */
    static boolean dfs(int start, int k) {
        int len = change.size(); // 약품을 투입할 위치와 약품 종류를 저장할 리스트의 크기
        if (len == k) { // 약품을 투입할 개수만큼 약품을 투입했으면
            for (Pair i : change) { // 약품을 투입한 위치에 약품을 투입
                // 약품을 투입한 위치의 모든 세로줄에 약품을 투입
                Arrays.fill(film[i.first], i.second);
            }
            boolean check = inspect(); // 검사
            for (int i = 0; i < D; i++) { // 보호필름 복사
                if (W >= 0) System.arraycopy(film_copy[i], 0, film[i], 0, W);
            }
            return check;
        }

        for (int i = start; i < D; i++) { // 약품을 투입할 위치
            change.add(new Pair(i, false)); // 약품을 투입하지 않은 경우

            if (dfs(i + 1, k)) return true; // 약품을 투입하지 않은 경우로 합격할 수 있는 경우
            change.remove(change.size() - 1); // 약품을 투입하지 않은 경우로 합격할 수 없는 경우
            change.add(new Pair(i, true)); // 약품을 투입한 경우

            if (dfs(i + 1, k)) return true; // 약품을 투입한 경우로 합격할 수 있는 경우
            change.remove(change.size() - 1); // 약품을 투입한 경우로 합격할 수 없는 경우
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int result;
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken()); // 두께
            W = Integer.parseInt(st.nextToken()); // 가로길이
            K = Integer.parseInt(st.nextToken()); // 합격기준

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) { // 보호필름 입력
                    film[i][j] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
            for (int i = 0; i < D; i++) { // 보호필름 복사
                if (W >= 0) System.arraycopy(film[i], 0, film_copy[i], 0, W);
            }

            result = K; // 약품을 투입하지 않고도 합격할 수 있는 경우
            for (int k = 0; k < K; k++) {
                change.clear(); // 약품을 투입할 위치와 약품 종류를 저장할 리스트 초기화
                if (dfs(0, k)) { // 약품을 투입하여 합격할 수 있는 경우
                    result = k;
                    break;
                }
            }

            bw.write("#" + t + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }

    static class Pair { // 약품을 투입할 위치와 약품 종류를 저장할 클래스
        int first;
        boolean second;

        public Pair(int first, boolean second) {
            this.first = first;
            this.second = second;
        }
    }
}