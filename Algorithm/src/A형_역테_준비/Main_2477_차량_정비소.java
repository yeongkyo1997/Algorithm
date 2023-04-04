package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2477_차량_정비소 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int K, win1[], win2[], customer[], N, M, A, B, result; // K = 고객수, win1 = A창구, win2 = B창구, customer = 고객들 도착시간, N = A창구수, M = B창구수, A = A창구 최대이용시간, B = B창구 최대이용시간, result = 최대이용시간
    static int atWin1[][], atWin2[][]; // atWin1 = A창구에 있는 사람, atWin2 = B창구에 있는 사람
    static boolean peopleA[], peopleB[]; // peopleA = A창구에 있는 사람 체크, peopleB = B창구에 있는 사람 체크
    static Queue<Integer> waiting = new LinkedList<>(); // waiting = 대기열

    static void solve() {
        int time = 0, custIdx = 0; // time = 시간, custIdx = 고객 인덱스
        int aCnt = 0, bCnt = 0; // aCnt = A창구에 있는 사람 수, bCnt = B창구에 있는 사람 수

        for (int i = 0; i < 10; i++) { // 초기화
            atWin1[i][0] = -1;
            atWin2[i][0] = -1;
            atWin1[i][1] = -1;
            atWin2[i][1] = -1;
        }

        while (true) {
            for (int i = 0; i < M; i++) { // B창구에 있는 사람 체크
                if (atWin2[i][1] == time) { // 시간이 되면
                    atWin2[i][0] = -1; // -1로 초기화
                }
            }


            for (int i = 0; i < N; i++) { // A창구에 있는 사람 체크
                if (atWin1[i][1] == time) { // 시간이 되면
                    waiting.add(atWin1[i][0]); // 대기열에 추가
                    atWin1[i][0] = -1; // -1로 초기화
                }
            }


            while (!waiting.isEmpty()) { // 대기열에 있는 사람 체크
                boolean isFull = true; // isFull = A창구가 꽉 찼는지 체크
                for (int i = 0; i < M; i++) { // B창구에 있는 사람 체크
                    if (atWin2[i][0] == -1) { // 비어있으면
                        atWin2[i][0] = waiting.poll(); // 대기열에서 꺼내서 넣음
                        atWin2[i][1] = time + win2[i]; // 시간 추가
                        bCnt++; // B창구에 있는 사람 수 추가
                        isFull = false; // 꽉 차지 않음
                        break;
                    }
                }
                if (isFull) break; // 꽉 찼으면 빠져나옴
            }


            for (int i = 0; i < N; i++) { // A창구에 있는 사람 체크
                if (custIdx >= K) break; // 고객수를 넘어가면 빠져나옴

                if (atWin1[i][0] == -1) { // 비어있으면
                    if (customer[custIdx] <= time) { // 시간이 되면
                        atWin1[i][0] = custIdx; // 고객 인덱스 추가
                        atWin1[i][1] = time + win1[i]; // 시간 추가
                        custIdx++; // 고객 인덱스 추가
                        aCnt++; // A창구에 있는 사람 수 추가
                    } else break; // 시간이 안되면 빠져나옴

                }
            }


            if (atWin1[A][0] != -1) peopleA[atWin1[A][0]] = true; // A창구에 있는 사람 체크
            if (atWin2[B][0] != -1) peopleB[atWin2[B][0]] = true; // B창구에 있는 사람 체크


            if (aCnt == K && bCnt == K) break; // A창구와 B창구에 있는 사람 수가 고객수와 같으면 빠져나옴

            time++; // 시간 추가
        }

        for (int i = 0; i < 1000; i++) { // 결과 계산
            if (peopleA[i] && peopleB[i]) result += i + 1; // A창구와 B창구에 있는 사람이 같으면 결과에 추가
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            result = 0;
            peopleA = new boolean[1000];
            peopleB = new boolean[1000];

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken()) - 1; // 인덱스를 위해 -1
            B = Integer.parseInt(st.nextToken()) - 1; // 인덱스를 위해 -1

            win1 = new int[N];
            win2 = new int[M];
            customer = new int[K];
            atWin1 = new int[10][2]; // 0번째는 고객 인덱스, 1번째는 시간
            atWin2 = new int[10][2]; // 0번째는 고객 인덱스, 1번째는 시간

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                win1[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                win2[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++)
                customer[i] = Integer.parseInt(st.nextToken());

            solve();

            bw.write("#" + t + " " + (result != 0 ? result : -1) + "\n"); // 결과가 0이면 -1 출력
        }

        bw.flush();
        bw.close();
    }
}

