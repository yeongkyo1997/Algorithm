package 미제출;

import java.util.*;

class Vertex {
    int r;
    int c;
    int time;

    public Vertex(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}

public class Main_3860_할로윈_묘지 {
    static int INF = 987654321;
    static int height, width, grave_num, hole_num;
    static boolean[][] is_grave = new boolean[31][31];
    static boolean[][] is_hole = new boolean[31][31];
    static int[][] change_pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<List<List<Vertex>>> adj;
    static List<List<Integer>> upper;

    public static boolean BellmanFord() {
        boolean is_updated = false;

        int time, next_r, next_c;
        for (int iter = 0; iter <= height * width - grave_num; ++iter) {
            for (int r = 0; r < height; ++r) {
                for (int c = 0; c < width; ++c) {
                    if (is_grave[r][c]) continue;
                    if (upper.get(r).get(c) == INF) continue;

                    for (int i = 0; i < adj.get(r).get(c).size(); ++i) {
                        next_r = adj.get(r).get(c).get(i).r;
                        next_c = adj.get(r).get(c).get(i).c;
                        time = adj.get(r).get(c).get(i).time;

                        if (time + upper.get(r).get(c) < upper.get(next_r).get(next_c)) {
                            if (iter == height * width - grave_num) is_updated = true;
                            upper.get(next_r).set(next_c, time + upper.get(r).get(c));
                        }
                    }

                }
            }
        }

        if (is_updated) return true;
        return false;
    }

    public static void GraphCreate() {
        int next_r, next_c, out_r, out_c, time;

        for (int r = 0; r < height; ++r) {
            for (int c = 0; c < width; ++c) {
                if (is_grave[r][c] || is_hole[r][c]) continue;
                if (r == (height - 1) && c == (width - 1)) continue;

                for (int i = 0; i < 4; ++i) {
                    next_r = r + change_pos[i][0];
                    next_c = c + change_pos[i][1];
                    if (next_r < 0 || height <= next_r || next_c < 0 || width <= next_c) continue;

                    if (is_grave[next_r][next_c]) continue;
                    adj.get(r).get(c).add(new Vertex(next_r, next_c, 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            width = sc.nextInt();
            height = sc.nextInt();
            if (width == 0) break;

            grave_num = sc.nextInt();
            adj = new ArrayList<>();
            for (int i = 0; i < height; i++) {
                adj.add(new ArrayList<>());
                for (int j = 0; j < width; j++) {
                    adj.get(i).add(new ArrayList<>());
                }
            }
            for (int i = 0; i < grave_num; ++i) {
                int c = sc.nextInt();
                int r = sc.nextInt();
                is_grave[r][c] = true;
            }

            hole_num = sc.nextInt();
            for (int i = 0; i < hole_num; ++i) {
                int in_c = sc.nextInt();
                int in_r = sc.nextInt();
                int out_c = sc.nextInt();
                int out_r = sc.nextInt();
                int time = sc.nextInt();
                is_hole[in_r][in_c] = true;
                adj.get(in_r).get(in_c).add(new Vertex(out_r, out_c, time));
            }

            GraphCreate();

            upper = new ArrayList<>();
            for (int i = 0; i < height; i++) {
                upper.add(new ArrayList<>());
                for (int j = 0; j < width; j++) {
                    upper.get(i).add(INF);
                }
            }
            upper.get(0).set(0, 0);

            boolean is_cycle = BellmanFord();
            if (is_cycle) System.out.println("Never");
            else if (upper.get(height - 1).get(width - 1) == INF) System.out.println("Impossible");
            else System.out.println(upper.get(height - 1).get(width - 1));

        }
        sc.close();
    }
}
