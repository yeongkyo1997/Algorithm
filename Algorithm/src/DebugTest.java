public class DebugTest {
    static int sum;
    static int[][] map = {{1, 2, 3, 4}, {11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34},};

    public static void main(String[] args) {
        debug();
    }

    private static void debug() {
        call(10);
        System.out.println(sum);
    }

    private static void call(int num) {
        for (int i = 1; i < num + 1; i++) {
            sum += i;
        }
    }
}
