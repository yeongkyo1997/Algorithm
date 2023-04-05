import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_2162_선분_그룹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Line[] line; // 선분의 정보
    static int N;    // 선분의 개수
    static int[] parent; // 부모 노드를 저장하는 배열

    static int find(int a) {
        if (parent[a] < 0) return a; // 부모 노드가 음수이면 루트 노드이므로 a를 리턴
        return parent[a] = find(parent[a]); // 부모 노드가 양수이면 부모 노드를 찾아서 리턴
    }

    static boolean isCycle(int a, int b) { // a와 b가 같은 집합에 속하는지 확인
        a = find(a); // a의 루트 노드를 찾음
        b = find(b); // b의 루트 노드를 찾음
        if (a == b) return true; // 루트 노드가 같으면 같은 집합에 속함
        else return false;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (parent[a] > parent[b]) { // a의 노드 개수가 더 많으면
            parent[b] += parent[a];
            parent[a] = b;
        } else {
            parent[a] += parent[b]; // b의 노드 개수가 더 많거나 같으면, 같은 경우는 a와 b의 노드 개수가 1인 경우
            parent[b] = a; // a의 루트 노드를 b로 설정
        }
    }

    static int CCW(P p1, P p2, P p3) { // p1, p2, p3가 반시계 방향이면 1, 시계 방향이면 -1, 일직선이면 0
        long res = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);


        if (res > 0) return 1;
        else if (res < 0) return -1;
        else return 0;
    }

    /*
     * 두 선분이 교차하는지 확인하는 함수
     */
    static boolean isLine(Line l1, Line l2) {
        int ccw1 = CCW(l1.p1, l1.p2, l2.p1) * CCW(l1.p1, l1.p2, l2.p2);
        int ccw2 = CCW(l2.p1, l2.p2, l1.p1) * CCW(l2.p1, l2.p2, l1.p2);

        if (ccw1 == 0 && ccw2 == 0) { // 두 선분이 일직선상에 있을 때
            if (l1.p1.x > l1.p2.x) { // l1의 x좌표를 오름차순으로 정렬
                P temp = l1.p1;
                l1.p1 = l1.p2;
                l1.p2 = temp;
            }
            if (l2.p1.x > l2.p2.x) { // l2의 x좌표를 오름차순으로 정렬
                P temp = l2.p1;
                l2.p1 = l2.p2;
                l2.p2 = temp;
            }

            return l1.p1.x <= l2.p2.x && l2.p1.x <= l1.p2.x; // 두 선분이 겹치는지 확인
        }

        return ccw1 <= 0 && ccw2 <= 0; // 두 선분이 교차하는지 확인
    }

    public static void main(String[] args) throws Exception {
        long x1, x2, y1, y2;
        P p1, p2;
        N = Integer.parseInt(br.readLine());
        line = new Line[N];
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Long.parseLong(st.nextToken());
            y1 = Long.parseLong(st.nextToken());
            x2 = Long.parseLong(st.nextToken());
            y2 = Long.parseLong(st.nextToken());
            p1 = new P(x1, y1);
            p2 = new P(x2, y2);
            line[i] = new Line(p1, p2);
        }

        IntStream.range(0, N).forEach(i -> parent[i] = -1);

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isLine(line[i], line[j]) && !isCycle(i, j)) union(i, j);
            }
        }

        int groupNum = 0;
        int largestGroupnum = 0;

        for (int i = 0; i < N; i++) {
            if (parent[i] < 0) { // 루트 노드인 경우
                groupNum++; // 집합의 개수
                largestGroupnum = Math.max(largestGroupnum, Math.abs(parent[i])); // 루트 노드의 개수가 가장 많은 집합의 개수
            }
        }

        bw.write(groupNum + "\n" + largestGroupnum); // 집합의 개수, 가장 많은 집합의 개수
        bw.flush();
    }

    static class P {
        long x, y;

        P(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        P p1, p2;

        Line(P p1, P p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}