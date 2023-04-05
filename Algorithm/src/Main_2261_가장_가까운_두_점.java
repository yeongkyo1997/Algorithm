import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2261_가장_가까운_두_점 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[][] pl;
    static int[][] tmp;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        pl = new int[n][2];
        tmp = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pl[i][0] = Integer.parseInt(st.nextToken());
            pl[i][1] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n - 1, 0);

        bw.write(dac(0, n - 1) + "\n");
        bw.flush();
        bw.close();
    }

    static int getDist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    static int dac(int start, int end) {

        if (start == end) {
            return Integer.MAX_VALUE;
        }

        if (end - start == 1) {
            return getDist(pl[start], pl[end]);
        }

        int mid = (start + end) / 2;
        int minDist = Math.min(dac(start, mid), dac(mid, end));

        int[] target_pl = new int[end - start + 1];
        int t = 0;
        for (int i = start; i <= end; i++) {
            if ((pl[mid][0] - pl[i][0]) * (pl[mid][0] - pl[i][0]) < minDist) {
                target_pl[t++] = i;
            }
        }

        mergeSort(start, end, 1);

        for (int i = 0; i < t - 1; i++) {
            for (int j = i + 1; j < t; j++) {
                if ((pl[target_pl[i]][1] - pl[target_pl[j]][1]) * (pl[target_pl[i]][1] - pl[target_pl[j]][1]) < minDist) {
                    minDist = Math.min(minDist, getDist(pl[target_pl[i]], pl[target_pl[j]]));
                } else {
                    break;
                }
            }
        }


        return minDist;
    }


    static void mergeSort(int start, int end, int idx) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, idx);
            mergeSort(mid + 1, end, idx);
            merge(start, mid, end, idx);
        }
    }

    static void merge(int start, int mid, int end, int idx) {
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (pl[i][idx] < pl[j][idx]) {
                tmp[k++] = pl[i++];
            } else {
                tmp[k++] = pl[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = pl[i++];
        }
        while (j <= end) {
            tmp[k++] = pl[j++];
        }
        if (end + 1 - start >= 0) System.arraycopy(tmp, start, pl, start, end + 1 - start);
    }
}