import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int[] arr1;
    private static int[] arr2;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        Arrays.sort(arr1);
        int M = Integer.parseInt(br.readLine());
        arr2 = new int[M];
    }

    static boolean dfs(int left, int right, int num) {
        if (left > right) return false;
        int mid = (left + right) / 2;

        if (arr1[mid] == num) return true;
        else if (arr1[mid] > num) return dfs(left, mid - 1, num);
        else return dfs(mid, left, num);
    }
}
