package 순조부;

import java.io.*;
import java.util.StringTokenizer;

public class NextPerm {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }


        nextPerm(input);

        for (int i : input) {
            bw.write(i + " ");
        }
        bw.close();
    }


//    static boolean nextPerm(int[] input) {
//        int n = input.length;
//
//        int i = n - 1;
//        while (i > 0 && input[i - 1] >= input[i]) i--;
//        if (i < 0) return false;
//
//        int j = n - 1;
//        while (input[i - 1] >= input[j]) j--;
//
//        swap(input, i - 1, j);
//
//        j = n - 1;
//        while (i < j) swap(input, i++, j--);
//        return true;
//    }

    static boolean nextPerm(int[] input) {
        int n = input.length;

        int i = n - 1;
        while (i > 0 && input[i - 1] >= input[i]) i--;

        if (i < 0) return false;

        int j = n - 1;
        while (input[i - 1] >= input[j]) j--;
        swap(input, i - 1, j);

        j = n - 1;
        while (i < j) swap(input, i++, j--);
        return true;
    }

    static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
