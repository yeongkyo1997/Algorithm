import java.util.*;

public class Solution {

    static int[][] board;
    static int n, m;

    static int[][][] visited;

    static int visCnt = -1;

    static List<int[]> getNexts(int i, int j, int k) {
        List<int[]> nexts = new ArrayList<>();
        int flag = board[i][j];
        if (flag == 1) {
            if (k == 0) {
                if (j != 0) {
                    nexts.add(new int[] { i, j - 1, 1 });
                }
                if (i != 0) {
                    int aFlag = board[i - 1][j];
                    if (aFlag == 1) {
                        nexts.add(new int[] { i - 1, j, 1 });
                    } else {
                        nexts.add(new int[] { i - 1, j, 0 });
                    }
                }
            } else {
                if (j != m - 1) {
                    nexts.add(new int[] { i, j + 1, 0 });
                }
                if (i != n - 1) {
                    int aFlag = board[i + 1][j];
                    if (aFlag == 1) {
                        nexts.add(new int[] { i + 1, j, 0 });
                    } else {
                        nexts.add(new int[] { i + 1, j, 1 });
                    }
                }
            }
        } else {
            if (k == 0) {
                if (j != 0) {
                    nexts.add(new int[] { i, j - 1, 1 });
                }
                if (i != n - 1) {
                    int aFlag = board[i + 1][j];
                    if (aFlag == 1) {
                        nexts.add(new int[] { i + 1, j, 0 });
                    } else {
                        nexts.add(new int[] { i + 1, j, 1 });
                    }
                }
            } else {
                if (j != m - 1) {
                    nexts.add(new int[] { i, j + 1, 0 });
                }
                if (i != 0) {
                    int aFlag = board[i - 1][j];
                    if (aFlag == 1) {
                        nexts.add(new int[] { i - 1, j, 1 });
                    } else {
                        nexts.add(new int[] { i - 1, j, 0 });
                    }
                }
            }
        }
        return nexts;
    }

    static int calculate(List<Integer> merged, boolean isCycle) {
        if (merged.isEmpty())
            return 0;
        int limit = merged.size();
        Set<Integer> dupCheckSet = new HashSet<>();
        boolean isDupExist = false;
        for (int el : merged) {
            if (dupCheckSet.contains(el)) {
                isDupExist = true;
                break;
            }
            dupCheckSet.add(el);
        }
        if (isDupExist)
            limit--;

        int ret = 0;
        if (isCycle) {
            List<Integer> dup = new ArrayList<>(merged);
            dup.addAll(merged);
            merged = dup;
        }
        int left = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        int dupCounts = 0;

        for (int right = 0; right < merged.size(); right++) {
            int el = merged.get(right);
            int count = memo.getOrDefault(el, 0);
            if (count == 0) {
                memo.put(el, 1);
            } else {
                if (count == 1) {
                    dupCounts++;
                }
                memo.put(el, count + 1);
            }
            while (dupCounts >= 1) {
                int leftEl = merged.get(left);
                int leftCount = memo.get(leftEl);
                if (leftCount == 2) {
                    dupCounts--;
                }
                if (leftCount == 1) {
                    memo.remove(leftEl);
                } else {
                    memo.put(leftEl, leftCount - 1);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return Math.min(limit, ret);
    }

    static List<Integer> go(int i, int j, int k) {
        List<Integer> acc = new ArrayList<>();
        if (visited[i][j][k] == visCnt)
            return acc;
        int key = i * m + j;
        acc.add(key);
        List<int[]> queue = new ArrayList<>();
        queue.add(new int[] { i, j, k });
        visited[i][j][k] = visCnt;
        while (!queue.isEmpty()) {
            List<int[]> newQueue = new ArrayList<>();
            for (int[] state : queue) {
                int x = state[0], y = state[1], z = state[2];
                List<int[]> nexts = getNexts(x, y, z);
                for (int[] next : nexts) {
                    int nx = next[0], ny = next[1], nz = next[2];
                    if (visited[nx][ny][nz] != visCnt) {
                        acc.add(nx * m + ny);
                        newQueue.add(new int[] { nx, ny, nz });
                        visited[nx][ny][nz] = visCnt;
                    }
                }
            }
            queue = newQueue;
        }
        return acc;
    }

    static int check(int i, int j, int k) {
        List<int[]> nexts = getNexts(i, j, k);
        visited[i][j][k] = ++visCnt;
        if (nexts.isEmpty())
            return 1;
        List<List<Integer>> results = new ArrayList<>();
        for (int[] next : nexts) {
            int x = next[0], y = next[1], z = next[2];
            results.add(go(x, y, z));
        }
        boolean isCycle = (results.size() == 2 && results.get(1).isEmpty());
        List<Integer> merged = new ArrayList<>(results.get(0));
        Collections.reverse(merged);
        merged.add(i * m + j);
        if (results.size() == 2) {
            for (int el : results.get(1)) {
                merged.add(el);
            }
        }
        return calculate(merged, isCycle);
    }

    public static int solution(int[][] gridInput) {
        board = gridInput;
        n = board.length;
        m = board[0].length;

        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    if (visited[i][j][k] == -1) {
                        res = Math.max(res, check(i, j, k));
                    }
                }
            }
        }
        return res;
    }
}
