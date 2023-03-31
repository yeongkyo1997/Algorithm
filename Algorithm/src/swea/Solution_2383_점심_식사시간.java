package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2383_점심_식사시간 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int m, min; // m: 사람 수, min: 최소 시간
    private static int[][] distance; // 사람과 계단간 거리
    private static Stairs[] stairs; // 계단 정보
    private static boolean[] choice; // 사람이 선택한 계단


    public static void main(String[] args) throws Exception {
        int n, idx, input;
        ArrayList<Index> people = new ArrayList<>();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            stairs = new Stairs[2]; // 초기화
            min = Integer.MAX_VALUE;
            idx = 0;
            people.clear();

            n = Integer.parseInt(br.readLine()); // 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    input = Integer.parseInt(st.nextToken());
                    if (input == 1) people.add(new Index(i, j));
                    else if (input != 0) stairs[idx++] = new Stairs(i, j, input);
                }
            }

            m = people.size();
            choice = new boolean[m];
            distance = new int[2][m];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < m; j++) {
                    distance[i][j] = getDist(stairs[i].index, people.get(j));
                }
            }
            choice(0);
            System.out.println("#" + t + " " + min);
        }
    }

    private static void choice(int depth) {
        if (m == depth) {
            solution(getDistInfo());
            return;
        }
        choice[depth] = true;
        choice(depth + 1);
        choice[depth] = false;
        choice(depth + 1);
    }

    private static void solution(int[] dst) {
        boolean[] check = new boolean[m];
        int count = 0;
        stairs[0].reset();
        stairs[1].reset();
        ArrayList<Integer> wait = new ArrayList<>();

        while (++count < min) { // min보다 오래 걸리면 종료
            wait.clear();
            for (int i = 0; i < m; i++) {
                if (check[i]) continue; // 이미 다 내려간 사람
                int s = (choice[i]) ? 0 : 1; // 계단 종류

                if (dst[i] == 0) wait.add(i); // 0인 사람은 밑의 for문에서 처리
                else {
                    if (--dst[i] < (-1) * stairs[s].value) {
                        stairs[s].out(); // 이동 완료
                        check[i] = true;
                    }
                }
            }
            for (Integer i : wait) {
                int s = (choice[i]) ? 0 : 1;
                if (stairs[s].status) { // 내려갈 수 있으면 내려감
                    dst[i]--;
                    stairs[s].down();
                }
            }
            if (isFinish(check)) min = count; // 다 내려오면
        }
    }

    private static boolean isFinish(boolean[] check) {
        for (int i = 0; i < m; i++) {
            if (!check[i]) return false;
        }
        return true;
    }

    private static int[] getDistInfo() {
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = (choice[i]) ? distance[0][i] : distance[1][i];
        }
        return result;
    }

    private static int getDist(Index a, Index b) { // 사람과 계단 사이 거리 측정
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

class Index {
    int x, y;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Stairs {
    Index index;
    int value, count;
    boolean status;

    public Stairs(int x, int y, int value) {
        this.index = new Index(x, y);
        this.value = value;
        this.count = 0;
        this.status = true;
    }

    public void down() {
        if (++count == 3) this.status = false; // 꽉차면 false 처리
    }

    public void reset() {
        this.count = 0;
        this.status = true;
    }

    public void out() {
        count--;
        this.status = true;
    }
}