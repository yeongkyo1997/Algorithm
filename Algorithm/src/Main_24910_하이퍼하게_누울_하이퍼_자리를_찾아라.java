import java.io.*;
import java.util.StringTokenizer;

public class Main_24910_하이퍼하게_누울_하이퍼_자리를_찾아라 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, k;
    static int[][] arr;
    static int[] pos;
    static int offset;
    static long start;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k][11];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 11; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        if (n == 1) {
            for (int i = 0; i < 11; i++) {
                bw.write("0\n");
            }
            bw.flush();
            bw.close();
            return;
        }

        start = 1;
        for (int i = 0; i < 10; i++) {
            start *= n;
        }

        for (int i = 0; i < 11; i++) {
            sort(i);
            offset = 0;
            pos = new int[k];

            if (k > 0) {
                int[] lPos = arr[0];

                pos[0] = lPos[i];

                for (int j = 1; j < k; j++) {
                    if (!isSame(lPos, arr[j], i)) {
                        int num = getArea(pos);
                        offset += num - 1;
                        pos = new int[k];
                    }

                    lPos = arr[j];
                    pos[j] = lPos[i];
                }

                int num = getArea(pos);
                offset += num - 1;
            }

            bw.write((start + offset) + "\n");
        }

        bw.flush();
        bw.close();
    }


    static void sort(int idx) {
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (arr[i][idx] > arr[j][idx]) {
                    int[] tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else if (arr[i][idx] == arr[j][idx]) {
                    for (int l = 0; l < 11; l++) {
                        if (idx == l) continue;

                        if (arr[i][l] > arr[j][l]) {
                            int[] tmp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = tmp;
                            break;
                        } else if (arr[i][l] < arr[j][l]) break;
                    }
                }
            }
        }
    }

    static boolean isSame(int[] left, int[] right, int idx) {
        for (int i = 0; i < 11; i++) {
            if (i == idx) continue;
            if (left[i] != right[i]) return false;
        }
        return true;
    }

    static int getArea(int[] pos) {
        int res = 1;
        for (int i = 0; i < k - 1; i++) {
            if (pos[i] + 1 != pos[i + 1]) {
                res++;
            }
        }
        return res;
    }
}