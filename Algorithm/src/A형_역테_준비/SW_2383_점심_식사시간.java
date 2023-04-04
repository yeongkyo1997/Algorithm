package A형_역테_준비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_2383_점심_식사시간 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
     * t1: 계단 1까지의 시간
     * t2: 계단 2까지의 시간
     * t: 계단 내려가는 시간
     * x, y: 좌표
     */
    static class Person {
        int x, y;
        int t1, t2;

        public Person(int x, int y, int t1, int t2) {
            this.x = x;
            this.y = y;
            this.t1 = t1;
            this.t2 = t2;
        }
    }

    /*
     * x, y: 좌표
     * t: 계단 내려가는 시간
     */
    static class Stair {
        int x, y;
        int t;

        public Stair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static List<Person> person = new ArrayList<>(); // 사람
    static List<Stair> stair = new ArrayList<>(); // 계단
    static int[] toWhere = new int[10]; // 사람이 갈 계단
    static int N, result; // 사람 수, 정답

    /*
     * v: 사람이 갈 계단
     * numStair: 계단 번호
     */
    static int down(List<Integer> v, int numStair) {
        if (v.isEmpty()) return 0; // 사람이 없으면 0 반환

        /*
         * 계단에 올라간 사람 수가 3명이 되면 계단 내려가는 시간을 1씩 줄여준다.
         */
        /*
         *정렬을 하는 이유는 계단에 올라간 사람 수가 3명이 되면 계단 내려가는 시간을 1씩 줄여주기 때문이다.
         */
        v.sort(null); // 오름차순 정렬
        int[] used = new int[3]; // 계단에 올라간 사람 수
        int time = v.get(0); // 시간

        while (true) { // 계단에 올라간 사람 수가 3명이 되면 계단 내려가는 시간을 1씩 줄여준다.
            for (int i = 0; i < v.size(); ++i) { // 사람이 갈 계단
                if (v.get(i) == -1) continue; // 계단에 올라간 사람 수가 3명이 되면 계단 내려가는 시간을 1씩 줄여준다.
                else if (v.get(i) > time) break; // 계단에 올라간 사람 수가 3명이 되면 계단 내려가는 시간을 1씩 줄여준다.

                for (int j = 0; j < 3; ++j) { // 계단에 올라간 사람 수

                    // 계단에 올라간 사람 수가 3명이 되면 계단 내려가는 시간을 1씩 줄여준다.
                    if (used[j] <= 0) {
                        if (i == v.size() - 1) return time + stair.get(numStair).t + 1;
                        used[j] = stair.get(numStair).t;
                        v.set(i, -1);
                        break;
                    }
                }
            }

            // 계단에 올라간 사람 수가 3명이 되면 계단 내려가는 시간을 1씩 줄여준다.
            for (int i = 0; i < 3; ++i)
                used[i]--;
            time++; // 시간 증가
        }
    }

    /*
     * idx: 사람 번호
     */

    static void dfs(int idx) {
        if (idx == person.size()) { // 모든 사람을 계단에 배치했으면
            List<Integer> v1 = new ArrayList<>(); // 계단 1에 갈 사람
            List<Integer> v2 = new ArrayList<>(); // 계단 2에 갈 사람

            for (int i = 0; i < person.size(); ++i) {
                if (toWhere[i] == 1) v1.add(person.get(i).t1); // 계단 1에 갈 사람
                else v2.add(person.get(i).t2); // 계단 2에 갈 사람
            }

            result = Math.min(result, Math.max(down(v1, 0), down(v2, 1)));  // 계단 1, 2에 갈 사람 중 더 오래 걸리는 시간
            return;
        }

        toWhere[idx] = 1; // 계단 1에 갈 사람
        dfs(idx + 1); // 다음 사람
        toWhere[idx] = 2; // 계단 2에 갈 사람
        dfs(idx + 1); // 다음 사람
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            person.clear();
            stair.clear();

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) person.add(new Person(i, j, 0, 0));
                    else if (x > 1) stair.add(new Stair(i, j, x));
                }
            }

            for (Person p : person) {
                p.t1 = Math.abs(p.x - stair.get(0).x) + Math.abs(p.y - stair.get(0).y);
                p.t2 = Math.abs(p.x - stair.get(1).x) + Math.abs(p.y - stair.get(1).y);
            }

            result = Integer.MAX_VALUE;
            dfs(0);
            bw.write("#" + t + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
