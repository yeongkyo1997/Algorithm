import java.io.*;
import java.util.*;

public class Main {

    static final long MOD1 = 1000000007L, MOD2 = 1000000009L;

    static final long R = 131L, C = 137L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hp = Integer.parseInt(st.nextToken());
        int wp = Integer.parseInt(st.nextToken());
        int hm = Integer.parseInt(st.nextToken());
        int wm = Integer.parseInt(st.nextToken());

        char[][] pattern = new char[hp][wp];
        for (int i = 0; i < hp; i++) {
            String line = br.readLine();
            pattern[i] = line.toCharArray();
        }

        char[][] masterpiece = new char[hm][wm];
        for (int i = 0; i < hm; i++) {
            String line = br.readLine();
            masterpiece[i] = line.toCharArray();
        }

        long[] powR1 = new long[Math.max(hm, hp) + 1];
        long[] powC1 = new long[Math.max(wm, wp) + 1];
        long[] powR2 = new long[Math.max(hm, hp) + 1];
        long[] powC2 = new long[Math.max(wm, wp) + 1];
        powR1[0] = 1;
        powR2[0] = 1;
        for (int i = 1; i < powR1.length; i++) {
            powR1[i] = (powR1[i - 1] * R) % MOD1;
            powR2[i] = (powR2[i - 1] * R) % MOD2;
        }
        powC1[0] = 1;
        powC2[0] = 1;
        for (int i = 1; i < powC1.length; i++) {
            powC1[i] = (powC1[i - 1] * C) % MOD1;
            powC2[i] = (powC2[i - 1] * C) % MOD2;
        }

        long[][] masterHash1 = new long[hm + 1][wm + 1];
        long[][] masterHash2 = new long[hm + 1][wm + 1];

        for (int i = 0; i < hm; i++) {
            for (int j = 0; j < wm; j++) {

                int val = (masterpiece[i][j] == 'x' ? 1 : 2);

                masterHash1[i + 1][j + 1] = ((masterHash1[i][j + 1] * R) % MOD1
                        + (masterHash1[i + 1][j] * C) % MOD1
                        - (masterHash1[i][j] * ((R * C) % MOD1)) % MOD1
                        + val) % MOD1;
                masterHash2[i + 1][j + 1] = ((masterHash2[i][j + 1] * R) % MOD2
                        + (masterHash2[i + 1][j] * C) % MOD2
                        - (masterHash2[i][j] * ((R * C) % MOD2)) % MOD2
                        + val) % MOD2;
                if (masterHash1[i + 1][j + 1] < 0)
                    masterHash1[i + 1][j + 1] += MOD1;
                if (masterHash2[i + 1][j + 1] < 0)
                    masterHash2[i + 1][j + 1] += MOD2;
            }
        }

        long[][] patternHash1 = new long[hp + 1][wp + 1];
        long[][] patternHash2 = new long[hp + 1][wp + 1];
        for (int i = 0; i < hp; i++) {
            for (int j = 0; j < wp; j++) {
                int val = (pattern[i][j] == 'x' ? 1 : 2);
                patternHash1[i + 1][j + 1] = ((patternHash1[i][j + 1] * R) % MOD1
                        + (patternHash1[i + 1][j] * C) % MOD1
                        - (patternHash1[i][j] * ((R * C) % MOD1)) % MOD1
                        + val) % MOD1;
                patternHash2[i + 1][j + 1] = ((patternHash2[i][j + 1] * R) % MOD2
                        + (patternHash2[i + 1][j] * C) % MOD2
                        - (patternHash2[i][j] * ((R * C) % MOD2)) % MOD2
                        + val) % MOD2;
                if (patternHash1[i + 1][j + 1] < 0)
                    patternHash1[i + 1][j + 1] += MOD1;
                if (patternHash2[i + 1][j + 1] < 0)
                    patternHash2[i + 1][j + 1] += MOD2;
            }
        }

        long patternFinal1 = patternHash1[hp][wp];
        long patternFinal2 = patternHash2[hp][wp];

        int count = 0;

        for (int i = 0; i <= hm - hp; i++) {
            for (int j = 0; j <= wm - wp; j++) {

                long curHash1 = masterHash1[i + hp][j + wp]
                        - (masterHash1[i][j + wp] * powR1[hp]) % MOD1
                        - (masterHash1[i + hp][j] * powC1[wp]) % MOD1
                        + (masterHash1[i][j] * ((powR1[hp] * powC1[wp]) % MOD1)) % MOD1;
                curHash1 %= MOD1;
                if (curHash1 < 0)
                    curHash1 += MOD1;

                long curHash2 = masterHash2[i + hp][j + wp]
                        - (masterHash2[i][j + wp] * powR2[hp]) % MOD2
                        - (masterHash2[i + hp][j] * powC2[wp]) % MOD2
                        + (masterHash2[i][j] * ((powR2[hp] * powC2[wp]) % MOD2)) % MOD2;
                curHash2 %= MOD2;
                if (curHash2 < 0)
                    curHash2 += MOD2;

                if (curHash1 == patternFinal1 && curHash2 == patternFinal2)
                    count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}