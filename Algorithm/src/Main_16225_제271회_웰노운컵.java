//#include <iostream>
//#include <vector>
//#include <algorithm>
//#include <queue>
//typedef struct pir {
//        int a, b;
//        }pir;
//        using namespace std;
//        int main() {
//        cin.tie(NULL); cout.tie(NULL);
//        ios::sync_with_stdio(false);
//
//        priority_queue <int> que;
//        int n;
//        pir ary[200000];
//        cin >> n;
//        for (int i = 0; i < n; i++)
//        cin >> ary[i].a;
//        for (int i = 0; i < n; i++)
//        cin >> ary[i].b;
//        sort(ary, ary + n, [](const pir&x, const pir&y)->bool {//정렬
//        return x.b < y.b;
//        });
//        long long ans = ary[0].a;
//
//        for (int i = 1; i < n - 1; i += 2) {
//        que.push(ary[i].a);
//        que.push(ary[i + 1].a);//2칸 삽입
//        ans += que.top();//최댓값 선택
//        que.pop();
//        }
//        cout << ans;
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_16225_제271회_웰노운컵 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int a, b;

        Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.b - o.b;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Node[] arr;

        st = new StringTokenizer(br.readLine());
        arr = IntStream.range(0, n).mapToObj(i -> new Node(Integer.parseInt(st.nextToken()), 0)).toArray(Node[]::new);

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, n).forEach(i -> arr[i].b = Integer.parseInt(st.nextToken()));

        Arrays.sort(arr);

        long ans = arr[0].a;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < n - 1; i += 2) {
            pq.add(arr[i].a);
            pq.add(arr[i + 1].a);
            ans += pq.poll();
        }
        bw.write(String.valueOf(ans));
        bw.close();
    }
}
