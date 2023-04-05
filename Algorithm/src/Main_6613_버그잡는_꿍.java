//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main_6613_버그잡는_꿍 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;
//    static int[] pi;
//
//    public static void main(String[] args) throws IOException {
//        while (true) {
//            st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            if (N == 0) break;
//
//            char[] S = st.nextToken().toCharArray();
//
//            pi = getPi(S);
//
//
//            for (int i = 0; i < N; i++) {
//                char[] ch=
//            }
//        }
//        bw.close();
//    }
//
//    static int[] getPi(char[] pattern) {
//        int[] pi = new int[pattern.length];
//        int j = 0;
//        for (int i = 1; i < pattern.length; i++) {
//            while (j > 0 && pattern[i] != pattern[j]) {
//                j = pi[j - 1];
//            }
//            if (pattern[i] == pattern[j]) {
//                pi[i] = ++j;
//            }
//        }
//        return pi;
//    }
//
//    static int[] kmp(char[] parent, char[] pattern) {
//        int[] ret = new int[parent.length];
//        int[] pi = getPi(pattern);
//        int j = 0;
//        for (int i = 0; i < parent.length; i++) {
//            while (j > 0 && parent[i] != pattern[j]) {
//                j = pi[j - 1];
//            }
//            if (parent[i] == pattern[j]) {
//                if (j == pattern.length - 1) {
//                    ret[i] = 1;
//                    j = pi[j];
//                } else {
//                    j++;
//                }
//            }
//        }
//        return ret;
//    }
//}
