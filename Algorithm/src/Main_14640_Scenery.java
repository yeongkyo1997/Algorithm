//#include <algorithm>
//#include <iostream>
//#include <queue>
//#include <vector>
//using namespace std;
//
//        struct Partial {
//        int t, curi, nphoto, dli;
//        long long sumstarts;
//        bool after_photo;
//
//        // Between two states at the same time we always maximize # of photos taken,
//        // and the times we started those photos.
//        bool operator<(const Partial& p) const {
//        if (t != p.t) return t > p.t;
//        if (nphoto != p.nphoto) return nphoto < p.nphoto;
//        return sumstarts < p.sumstarts;
//        }
//        };
//
//        int main() {
//        int N, T;
//        while (cin >> N >> T) {
//        vector<pair<int, int>> V(N);
//        for (int i = 0; i < N; i++) cin >> V[i].first >> V[i].second;
//        sort(V.begin(), V.end());
//
//        bool ret = false;
//        priority_queue<Partial> q;
//        vector<priority_queue<int>> deadlines(1);  // Maintain O(N) heaps.
//        Partial start;
//        start.after_photo = false;
//        start.t = start.curi = start.nphoto = start.dli = start.sumstarts = 0;
//        q.push(start);
//
//        while (!q.empty()) {
//        Partial p = q.top();
//        while (!q.empty() && q.top().t == p.t) q.pop();
//        if (p.nphoto == N) {
//        ret = true;
//        break;
//        }
//
//        if (p.after_photo) {
//        deadlines[p.dli].pop();
//        } else {
//        deadlines.push_back(deadlines[p.dli]);
//        p.dli = deadlines.size()-1;
//        }
//        priority_queue<int>& dl = deadlines[p.dli];
//        for (; p.curi < V.size() && V[p.curi].first <= p.t; p.curi++) {
//        dl.push(-V[p.curi].second);
//        }
//        if (dl.size() && -dl.top() < p.t + T) continue;
//
//        if (p.curi < V.size() && (!dl.size() || V[p.curi].first < p.t+T)) {
//        p.after_photo = false;
//        int ot = p.t;
//        p.t = V[p.curi].first;
//        q.push(p);
//        p.t = ot;
//        }
//
//        if (dl.size()) {
//        p.after_photo = true;
//        p.nphoto++;
//        p.sumstarts += p.t;
//        p.t += T;
//        q.push(p);
//        }
//        }
//
//        cout << (ret ? "yes" : "no") << endl;
//        }
//        }

//cpp to java

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_14640_Scenery {
    static Scanner sc = new Scanner(System.in);

    static class Partial implements Comparable<Partial> {
        int t, curi, nphoto, dli;
        long sumstarts;
        boolean after_photo;

        @Override
        public int compareTo(Partial p) {
            return t != p.t ? t > p.t ? 1 : -1 : nphoto != p.nphoto ? nphoto < p.nphoto ? 1 : -1 : sumstarts < p.sumstarts ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        int N, T;
        while (sc.hasNextInt()) {
            N = sc.nextInt();
            T = sc.nextInt();

            List<int[]> V = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                V.add(new int[]{sc.nextInt(), sc.nextInt()});
            }

            for (int i = 0; i < N; i++) {
                V.add(new int[2]);
            }
            V.sort((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

            boolean ret = false;
            PriorityQueue<Partial> q = new PriorityQueue<>();
            List<PriorityQueue<Integer>> deadlines = new ArrayList<>();
            deadlines.add(new PriorityQueue<>());
            Partial start = new Partial();
            start.after_photo = false;
            start.t = start.curi = start.nphoto = start.dli = 0;
            start.sumstarts = 0;
            q.add(start);

            while (!q.isEmpty()) {
                Partial p = q.poll();
                while (!q.isEmpty() && q.peek().t == p.t) q.poll();
                if (p.nphoto == N) {
                    ret = true;
                    break;
                }

                if (p.after_photo) {
                    deadlines.get(p.dli).poll();
                } else {
                    deadlines.add(deadlines.get(p.dli));
                    p.dli = deadlines.size() - 1;
                }
                PriorityQueue<Integer> dl = deadlines.get(p.dli);
                for (; p.curi < V.size() && V.get(p.curi)[0] <= p.t; p.curi++) {
                    dl.add(-V.get(p.curi)[1]);
                }
                if (dl.size() > 0 && -dl.peek() < p.t + T) continue;

                if (p.curi < V.size() && (dl.size() == 0 || V.get(p.curi)[0] < p.t + T)) {
                    p.after_photo = false;
                    int ot = p.t;
                    p.t = V.get(p.curi)[0];
                    q.add(p);
                    p.t = ot;
                }

                if (dl.size() != 0) {
                    p.after_photo = true;
                    p.nphoto++;
                    p.sumstarts += p.t;
                    p.t += T;
                    q.add(p);
                }
            }

            System.out.println(ret ? "yes" : "no");
        }
    }
}
