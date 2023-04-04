import java.io.*;
import java.util.*;

public class Main_17135_캐슬_디펜스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    static class Castle implements Comparable<Castle> {
        int x, y, z;

        public Castle(int x, int y, int z) { // x: 행, y: 열, z: 거리
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Castle(int x, int y) { // x: 행, y: 열
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Castle o) { // 거리가 가까운 적부터, 거리가 같으면 왼쪽부터
            if (this.z == o.z) return this.y - o.y;
            return this.z - o.z;
        }
    }


    static int n, m, d, result; // 행, 열, 궁수 사정거리
    static int[][] a = new int[15][15]; // 맵
    static int[] archer = new int[3]; // 궁수 위치

    static void kill() {// 궁수 3명 배치
        int[][] b = new int[15][15]; // 맵
        int cnt = 0, t = n; // 적의 수, 시간

        // 배열 복사
        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(a[i], 0, b[i], 0, m);

        }
        // 궁수 3명 배치
        while (t-- != 0) {
            List<Castle> list = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                PriorityQueue<Castle> pq = new PriorityQueue<>(); // 거리가 가까운 적부터, 거리가 같으면 왼쪽부터

                // 궁수 사정거리 안에 있는 적 찾기
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (b[j][k] != 0) { // 적이 있으면
                            int dist = Math.abs(n - j) + Math.abs(archer[i] - k); // 거리 계산
                            if (dist <= d) pq.add(new Castle(j, k, dist)); // 거리가 사정거리 이하면 큐에 삽입
                        }
                    }
                }

                if (!pq.isEmpty()) { // 큐가 비어있지 않으면
                    int x = pq.peek().x, y = pq.peek().y; // 가장 가까운 적의 위치
                    list.add(new Castle(x, y)); // 죽일 적의 위치 저장
                }
            }

            for (Castle castle : list) { // 죽일 적의 위치
                int x = castle.x, y = castle.y; // 적의 위치
                if (b[x][y] != 0) { // 적이 있으면
                    b[x][y] = 0; // 적 제거
                    cnt += 1;   // 적의 수 증가
                }
            }

            // 적 이동
            for (int i = n - 2; i >= 0; i--) {
                if (m >= 0) System.arraycopy(b[i], 0, b[i + 1], 0, m);
            }

            // 맨 윗줄 0으로 초기화
            Arrays.fill(b[0], 0);
        }
        // 최대값 갱신
        if (result < cnt) result = cnt;
    }

    // 2. 궁수 3명 배치
    static void solve() {
        // 궁수 3명 배치
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    archer[0] = i;
                    archer[1] = j;
                    archer[2] = k;
                    kill(); // 적 제거
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        bw.write(result + "\n");
        bw.close();
    }
}