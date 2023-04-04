//import bisect
//T = int(input())
//        N = int(input())
//        Aarr = list(map(int,input().split()))
//        M = int(input())
//        Barr = list(map(int,input().split()))
//        Asum = []
//        Bsum = []
//        for i in range(N):  #O(A*(A-1)/2)
//        s = Aarr[i]
//        Asum.append(s)
//        for j in range(i+1,N):
//        s+=Aarr[j]
//        Asum.append(s)
//        for i in range(M):  #O(B*(B-1)/2)
//        s = Barr[i]
//        Bsum.append(s)
//        for j in range(i+1,M):
//        s+=Barr[j]
//        Bsum.append(s)
//        Asum.sort()
//        Bsum.sort()
//        answer = 0
//        for i in range(len(Asum)):
//        l = bisect.bisect_left(Bsum,T-Asum[i])
//        r = bisect.bisect_right(Bsum,T-Asum[i])
//        answer+=r-l
//        print(answer)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

//py3 to java
public class Main_2143_두_배열의_합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N, M;
    static int[] A, B;
    static int[] Asum, Bsum;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());

        IntStream.range(0, M).forEach(i -> B[i] = Integer.parseInt(st.nextToken()));

        Asum = new int[N * (N + 1) / 2];
        Bsum = new int[M * (M + 1) / 2];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            int s = A[i];
            Asum[idx++] = s;
            for (int j = i + 1; j < N; j++) {
                s += A[j];
                Asum[idx++] = s;
            }
        }

        idx = 0;
        for (int i = 0; i < M; i++) {
            int s = B[i];
            Bsum[idx++] = s;
            for (int j = i + 1; j < M; j++) {
                s += B[j];
                Bsum[idx++] = s;
            }
        }

        Arrays.sort(Asum);
        Arrays.sort(Bsum);
        long result = 0;
        for (int j : Asum) {
            int l = lowerBound(Bsum, T - j);
            int r = upperBound(Bsum, T - j);
            result += r - l;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int lowerBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static int upperBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}