import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] map = new int[102];
    static boolean[] visit = new boolean[102];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t1, t2;

        for (int i = 0; i < n; i++) {
            t1 = scanner.nextInt();
            t2 = scanner.nextInt();
            map[t1] = t2; // 사다리 저장
        }

        for (int i = 0; i < m; i++) {
            t1 = scanner.nextInt();
            t2 = scanner.nextInt();
            map[t1] = t2; // 뱀 저장
        }

        game(1, 0);
    }

    static void game(int x, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, c});

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int loc = info[0]; // 현재 좌표
            int cnt = info[1]; // 카운트

            for (int i = 1; i <= 6; i++) {
                int nx = loc + i; // 다음 좌표

                if (nx == 100) {
                    System.out.println(cnt + 1); // 도착했으면 출력
                    return;
                } else if (nx < 100) { // 100보다 작은 좌표라면
                    while (map[nx] != 0) { // 사다리 혹은 뱀인지 확인
                        nx = map[nx]; // 점프한 자리로 이동
                    }

                    if (!visit[nx]) { // 처음 방문한 좌표일 때
                        queue.offer(new int[]{nx, cnt + 1}); // 큐에 넣어줌
                        visit[nx] = true; // 방문처리
                    }
                }
            }
        }
    }
}