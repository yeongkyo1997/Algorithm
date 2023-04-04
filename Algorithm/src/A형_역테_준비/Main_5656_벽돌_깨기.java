package A형_역테_준비;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_5656_벽돌_깨기 {
    static int[] number; // 구슬을 떨어뜨릴 위치
    static int[][] map, map2; // map2는 구슬을 떨어뜨린 후의 상태를 저장
    static int N, W, H, result = Integer.MAX_VALUE; // N : 구슬의 개수, W : 가로, H : 세로, ans : 최소 벽돌의 개수
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            result = Integer.MAX_VALUE; // 초기화
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 구슬의 개수
            W = Integer.parseInt(st.nextToken()); // 가로
            H = Integer.parseInt(st.nextToken()); // 세로

            number = new int[N]; // 구슬을 떨어뜨릴 위치
            map = new int[H][W]; // map2는 구슬을 떨어뜨린 후의 상태를 저장

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            perm(0); // 구슬을 떨어뜨릴 위치를 정함
            System.out.println("#" + t + " " + result);
        }

    }

    private static void perm(int cnt) {
        if (cnt == N) { // 구슬을 떨어뜨릴 위치를 모두 정했으면
            beok(); // 구슬을 떨어뜨림

            int sum = 0;
            for (int i = 0; i < H; i++) { // 남은 벽돌의 개수를 세서 최소값을 구함
                for (int j = 0; j < W; j++) {
                    if (map2[i][j] != 0) sum++;
                }
            }

            result = Math.min(result, sum); // 최소값을 구함
            return;
        }

        for (int i = 0; i < W; i++) { // 구슬을 떨어뜨릴 위치를 정함
            number[cnt] = i;
            perm(cnt + 1);
        }
    }

    /*
     * 구슬을 떨어뜨림
     * 구슬은 가로 한줄로도 벽돌을 부수기 때문에 선택된 열뿐만 아니라 모든 열들에 대해 벽돌을 내려주는 로직을 짜야함
     */
    private static void beok() {
        map2 = new int[H][W];
        for (int i = 0; i < H; i++) {
            if (W >= 0) System.arraycopy(map[i], 0, map2[i], 0, W);
        }

        // 구슬은 가로 한줄로도 벽돌을 부수기 때문에 선택된 열뿐만 아니라 모든 열들에 대해 벽돌을 내려주는 로직을 짜야함
        // 편의를 함수로 뺌(이름 : down)
        for (int j : number) {
            int x = 0;
            int y = 0;

            for (int i = 0; i < H; i++) {
                if (map2[i][j] != 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
            remove(x, y); // 벽돌을 부수는 함수
            down();
        }

    }

    static void down() { // 벽돌을 내려주는 함수
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) if (map2[j][i] != 0) stack.add(map2[j][i]);
            for (int j = H - 1; j >= 0; j--) {
                map2[j][i] = stack.isEmpty() ? 0 : stack.pop();
            }
        }
    }

    private static void remove(int i, int j) { // 벽돌을 부수는 함수
        int tmp = map2[i][j];
        map2[i][j] = 0;

        for (int c = 1; c < tmp; c++) {
            if (i + c < H) remove(i + c, j);
            if (i - c >= 0) remove(i - c, j);
            if (j + c < W) remove(i, j + c);
            if (j - c >= 0) remove(i, j - c);
        }
    }
}