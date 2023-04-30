//N = int(input())
//
//        if N == 1:
//        print('*')
//
//        else:
//        for n in range(N):
//        if n % 2 == 0:
//        a = print('* ' * N)
//        else:
//        b = print(' *' * N)

//py3 to java

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main_10995_별_찍기_20 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        if (N == 1) {
            System.out.println("*");
        } else {
            for (int n = 0; n < N; n++) {
                if (n % 2 == 0) {
                    IntStream.range(0, N).mapToObj(i -> "* ").forEach(System.out::print);
                    System.out.println();
                } else {
                    IntStream.range(0, N).mapToObj(i -> " *").forEach(System.out::print);
                    System.out.println();
                }
            }
        }
    }
}