import java.util.Scanner;

public class Main_1821_수들의_합_6 {
    static int N, F;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        F = scanner.nextInt();
        nums = new int[N];
        visited = new boolean[N + 1];

        findTopRow();
    }

    public static void findTopRow() {
        int depth = 0;
        while (depth >= 0) {
            visited[nums[depth]] = false;
            nums[depth]++;
            while (nums[depth] <= N && visited[nums[depth]]) {
                nums[depth]++;
            }

            if (nums[depth] <= N) {
                visited[nums[depth]] = true;
                if (depth == N - 1) {
                    int lastValue = calculateLastValue();
                    if (lastValue == F) {
                        for (int i = 0; i < N; i++) {
                            System.out.print(nums[i] + " ");
                        }
                        return;
                    }
                } else {
                    depth++;
                }
            } else {
                depth--;
            }
        }
    }

    public static int calculateLastValue() {
        int[] previousRow = new int[N];
        System.arraycopy(nums, 0, previousRow, 0, N);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                previousRow[j] = previousRow[j] + previousRow[j + 1];
            }
        }
        return previousRow[0];
    }
}
