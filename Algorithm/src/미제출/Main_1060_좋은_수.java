package 미제출;

import java.util.*;
import java.io.*;

public class Main_1060_좋은_수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int L, S;
    static long[] arr = new long[100];
    static ArrayList<Pair> goodNums = new ArrayList<>();

    static void printResult() throws IOException {
        long printedCount = 0;
        ArrayList<Long> printed = new ArrayList<>();
        for (long i = 0; i < Math.min(S, goodNums.size()); i++) {
            bw.write(goodNums.get((int) i).second + " ");
            printed.add(goodNums.get((int) i).second);
            printedCount++;
        }
        long num = 0;
        while (printedCount < S) {
            num++;
            boolean isPrinted = false;
            for (long i = 0; i < printed.size(); i++) {
                if (num == printed.get((int) i)) {
                    isPrinted = true;
                    break;
                }
            }
            if (isPrinted) continue;

            bw.write(num + " ");

            printed.add(num);
            printedCount++;
        }
    }

    static void findGoodNums(long left, long right) {
        long rangeCount = right - left;
        long inc = rangeCount - 1;
        long pushCount = 0;

        for (long i = 0; i <= (left + right) / 2; i++) {
            if (pushCount > S || right - i < left + i) break;
            goodNums.add(new Pair(rangeCount, left + i));
            pushCount++;
            if (right - i != left + i) {
                goodNums.add(new Pair(rangeCount, right - i));
                pushCount++;
            }
            rangeCount += inc;
            inc -= 2;
        }
    }

    static void inputArr(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            goodNums.add(new Pair(0, arr[i]));
        }
    }

    public static void main(String[] args) throws IOException {
        L = Integer.parseInt(br.readLine());
        inputArr(br);
        Arrays.sort(arr, 0, L);
        S = Integer.parseInt(br.readLine());
        findGoodNums(1, arr[0] - 1);
        for (int i = 0; i < L - 1; i++) findGoodNums(arr[i] + 1, arr[i + 1] - 1);
        Collections.sort(goodNums);
        printResult();
        bw.close();
    }
}

class Pair implements Comparable<Pair> {
    long first;
    long second;

    public Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return Long.compare(this.first, o.first);
    }
}
