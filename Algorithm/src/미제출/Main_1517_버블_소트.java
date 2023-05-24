package 미제출;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1517_버블_소트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int[] arr = new int[500001];
    static int[] tmp = new int[500001];
    static long result = 0;

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
    }

    public static void merge(int start, int last) {
        int mid = (start + last) / 2;
        int i = start;
        int j = mid + 1;
        int k = start;
        int cnt = 0;

        while (i <= mid && j <= last) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
                result += cnt;
            } else {
                tmp[k++] = arr[j++];
                cnt++;
            }
        }

        if (i > mid) {
            int s = j;
            while (s <= last) {
                tmp[k++] = arr[s++];
                cnt++;
            }
        } else {
            int s = i;
            while (s <= mid) {
                tmp[k++] = arr[s++];
                result += cnt;
            }
        }

        if (last + 1 - start >= 0) System.arraycopy(tmp, start, arr, start, last + 1 - start);
    }

    public static void mergesort(int start, int last) {
        if (start < last) {
            int mid = (start + last) / 2;
            mergesort(start, mid);
            mergesort(mid + 1, last);
            merge(start, last);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        mergesort(0, n - 1);
        bw.write(String.valueOf(result));
        bw.close();
    }
}
