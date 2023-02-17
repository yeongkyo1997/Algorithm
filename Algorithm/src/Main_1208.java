import java.io.*;
import java.util.StringTokenizer;

// BOJ 1208 부분수열의 합 2
public class Main_1208 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[N / 2];
        int[] right = new int[N - N / 2];
        for (int i = 0; i < N / 2; i++) {
            left[i] = list[i];
        }

        for (int i = N / 2; i < N; i++) {
            right[i - N / 2] = list[i];
        }

        int[] leftSum = new int[1 << (N / 2)];
        int[] rightSum = new int[1 << (N - N / 2)];

        for (int i = 0; i < (1 << (N / 2)); i++) {
            for (int j = 0; j < N / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    leftSum[i] += left[j];
                }
            }
        }

        for (int i = 0; i < (1 << (N - N / 2)); i++) {
            for (int j = 0; j < N - N / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    rightSum[i] += right[j];
                }
            }
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int leftLen = 1 << (N / 2);
        int rightLen = 1 << (N - N / 2);
        long result = 0;
        while (leftIdx < leftLen && rightIdx < rightLen) {
            if (leftSum[leftIdx] + rightSum[rightIdx] == S) {
                long leftCnt = 0;
                long rightCnt = 0;
                while (leftIdx < leftLen && leftSum[leftIdx] == leftSum[leftIdx + 1]) {
                    leftCnt++;
                    leftIdx++;
                }
                while (rightIdx < rightLen && rightSum[rightIdx] == rightSum[rightIdx + 1]) {
                    rightCnt++;
                    rightIdx++;
                }
                result += (leftCnt + 1) * (rightCnt + 1);
                leftIdx++;
                rightIdx++;
            } else if (leftSum[leftIdx] + rightSum[rightIdx] < S) {
                leftIdx++;
            } else {
                rightIdx++;
            }
        }

        if (S == 0) {
            result--;
        }

        bw.write(result + "\n");
        bw.close();
    }
}