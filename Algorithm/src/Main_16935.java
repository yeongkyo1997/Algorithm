import java.io.*;
import java.util.StringTokenizer;

public class Main_16935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N, M, R;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < R; i++) {
            int order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    map = order1(map);
                    break;
                case 2:
                    map = order2(map);
                    break;
                case 3:
                    map = order3(map);
                    break;
                case 4:
                    map = order4(map);
                    break;
                case 5:
                    map = order5(map);
                    break;
                case 6:
                    map = order6(map);
                    break;
            }
        }

        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) bw.write(ints[j] + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static int[][] order1(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[map.length - 1 - i], 0, newMap[i], 0, map[0].length);
        }
        return newMap;
    }


    private static int[][] order2(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) newMap[i][j] = map[i][map[0].length - 1 - j];
        }
        return newMap;
    }

    private static int[][] order3(int[][] map) {
        int[][] newMap = new int[map[0].length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) newMap[j][map.length - 1 - i] = map[i][j];
        }
        return newMap;
    }

    private static int[][] order4(int[][] map) {
        int[][] newMap = new int[map[0].length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) newMap[map[0].length - 1 - j][i] = map[i][j];
        }
        return newMap;
    }

    private static int[][] order5(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];

        for (int i = 0; i < map.length / 2; i++) {
            System.arraycopy(map[i], 0, newMap[i], map[0].length / 2, map[0].length / 2);
        }

        for (int i = 0; i < map.length / 2; i++) {
            if (map[0].length - map[0].length / 2 >= 0)
                System.arraycopy(map[i], map[0].length / 2, newMap[i + map.length / 2], map[0].length / 2, map[0].length - map[0].length / 2);
        }

        for (int i = map.length / 2; i < map.length; i++) {
            if (map[0].length - map[0].length / 2 >= 0)
                System.arraycopy(map[i], map[0].length / 2, newMap[i], 0, map[0].length - map[0].length / 2);
        }

        for (int i = map.length / 2; i < map.length; i++) {
            System.arraycopy(map[i], 0, newMap[i - map.length / 2], 0, map[0].length / 2);
        }
        return newMap;
    }

    private static int[][] order6(int[][] map) {
        int[][] newMap = new int[map.length][map[0].length];

        for (int i = 0; i < map.length / 2; i++)
            System.arraycopy(map[i], 0, newMap[i + map.length / 2], 0, map[0].length / 2);

        for (int i = 0; i < map.length / 2; i++) {
            if (map[0].length - map[0].length / 2 >= 0)
                System.arraycopy(map[i], map[0].length / 2, newMap[i], 0, map[0].length - map[0].length / 2);
        }

        for (int i = map.length / 2; i < map.length; i++) {
            if (map[0].length - map[0].length / 2 >= 0)
                System.arraycopy(map[i], map[0].length / 2, newMap[i - map.length / 2], map[0].length / 2, map[0].length - map[0].length / 2);
        }

        for (int i = map.length / 2; i < map.length; i++) {
            System.arraycopy(map[i], 0, newMap[i], map[0].length / 2, map[0].length / 2);
        }
        return newMap;
    }
}