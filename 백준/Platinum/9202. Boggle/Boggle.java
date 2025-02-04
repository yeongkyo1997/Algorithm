import java.io.*;
import java.util.*;

public class Main {

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;
        String word = "";
        int foundAt = -1;
    }

    static Trie root = new Trie();

    static void insert(String s) {
        Trie cur = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            if (cur.children[idx] == null)
                cur.children[idx] = new Trie();
            cur = cur.children[idx];
        }
        cur.isEnd = true;
        cur.word = s;
        cur.foundAt = -1;
    }

    static int[] scoreTable = { 0, 0, 0, 1, 1, 2, 3, 5, 11 };

    static final int BOARD_SIZE = 4;
    static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    static boolean[][] visited = new boolean[BOARD_SIZE][BOARD_SIZE];

    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static int currentBoardId;

    static int totalScore;
    static String longestWord;
    static int foundCount;

    static void dfs(int x, int y, Trie node) {
        int idx = board[x][y] - 'A';
        if (node.children[idx] == null)
            return;
        Trie next = node.children[idx];
        visited[x][y] = true;

        if (next.isEnd) {
            if (next.foundAt != currentBoardId) {
                next.foundAt = currentBoardId;
                int len = next.word.length();
                totalScore += scoreTable[len];
                foundCount++;

                if (next.word.length() > longestWord.length() ||
                        (next.word.length() == longestWord.length() && next.word.compareTo(longestWord) < 0)) {
                    longestWord = next.word;
                }
            }
        }

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx < 0 || nx >= BOARD_SIZE || ny < 0 || ny >= BOARD_SIZE)
                continue;
            if (!visited[nx][ny])
                dfs(nx, ny, next);
        }

        visited[x][y] = false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int w = Integer.parseInt(br.readLine());
        for (int i = 0; i < w; i++) {
            String word = br.readLine().trim();
            insert(word);
        }

        br.readLine();

        int b = Integer.parseInt(br.readLine());
        for (int bi = 0; bi < b; bi++) {

            for (int i = 0; i < BOARD_SIZE; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            if (bi < b - 1)
                br.readLine();

            totalScore = 0;
            longestWord = "";
            foundCount = 0;
            currentBoardId = bi;
            for (int i = 0; i < BOARD_SIZE; i++)
                Arrays.fill(visited[i], false);

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    dfs(i, j, root);
                }
            }

            bw.write(totalScore + " " + longestWord + " " + foundCount);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}