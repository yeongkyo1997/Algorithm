package 미제출;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1071_소트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> v = new ArrayList<>(n);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            v.add(input);
        }

        Collections.sort(v);

        for (int i = 0; i < n; i++) {
            if (i + 1 < n && v.get(i) + 1 == v.get(i + 1)) {
                int end = i + 2;
                if (end != n) {
                    while (end < n && v.get(end).equals(v.get(i + 1))) {
                        end++;
                    }
                }

                if (end == n) {
                    int start = i - 1;
                    if (start >= 0) {
                        while (start >= 0 && v.get(start).equals(v.get(i))) {
                            start--;
                        }
                    }

                    v.set(start + 1, v.get(start + 1) + 1);
                    v.set(i + 1, v.get(i + 1) - 1);
                } else {
                    int temp = v.get(end);
                    v.set(end, v.get(i + 1));
                    v.set(i + 1, temp);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(v.get(i) + " ");
        }
        bw.close();
    }
}
