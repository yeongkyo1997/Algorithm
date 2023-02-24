//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class Main_9375 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer st;
//<<<<<<< HEAD
//    private static int result;
//
//    public static void main(String[] args) throws IOException {
//        int T = Integer.parseInt(br.readLine());
//
//        for (int t = 0; t < T; t++) {
//            int N = Integer.parseInt(br.readLine());
//            Map<String, Integer> map = new HashMap<>();
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                st.nextToken();
//                String key = st.nextToken();
//                map.put(key, map.getOrDefault(key, 0) + 1);
//            }
//            result = 1;
//            for (int value : map.values()) {
//                result *= (value + 1);
//            }
//            bw.write(result - 1 + "\n");
//
//        }
//        bw.close();
//    }
//}
//=======
//
//    public static void main(String[] args) throws IOException {
//        Map<String, Integer> map = new HashMap<>();
//
//        int T = Integer.parseInt(br.readLine());
//
//        while (T-- != 0) {
//            int N = Integer.parseInt(br.readLine());
//            map.clear();
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                st.nextToken();
//                String str = st.nextToken();
//                map.put(str, map.getOrDefault(str, 0) + 1);
//            }
//            int sum = 1;
//            for (int value : map.values()) {
//                sum *= (value + 1);
//            }
//            bw.write(sum - 1 + "\n");
//        }
//        bw.close();
//    }
//}
//>>>>>>> 8fcf9b03b4c4fb8d39a07423a5cf6515f36984b2
