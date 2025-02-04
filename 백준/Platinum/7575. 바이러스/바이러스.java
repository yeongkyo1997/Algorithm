import java.io.*;
import java.util.*;

public class Main {
    static final long MOD1 = 1000000007L;
    static final long MOD2 = 1000000009L;
    static final long BASE = 10007L;
    
    public static void main(String[] args) throws Exception {
        // 입출력 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 감염된 프로그램 수 (2 ≤ N ≤ 100)
        int K = Integer.parseInt(st.nextToken()); // 최소 바이러스 코드 길이 (4 ≤ K ≤ 1000)
        
        // 모든 프로그램의 코드를 저장
        int[][] programs = new int[N][];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine().trim());
            maxLen = Math.max(maxLen, M);
            programs[i] = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                programs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 미리 base의 거듭제곱을 계산 (길이 최대 maxLen)
        long[] basePow1 = new long[maxLen+1];
        long[] basePow2 = new long[maxLen+1];
        basePow1[0] = 1; basePow2[0] = 1;
        for (int i = 1; i <= maxLen; i++) {
            basePow1[i] = (basePow1[i-1] * BASE) % MOD1;
            basePow2[i] = (basePow2[i-1] * BASE) % MOD2;
        }
        
        // 첫 번째 프로그램은 후보 구간을 순회할 대상
        int[] prog0 = programs[0];
        int len0 = prog0.length;
        // 만약 첫번째 프로그램의 길이가 K보다 작으면 당연히 NO (문제조건상 M>=10이므로 발생하지 않음)
        if(len0 < K){
            bw.write("NO\n");
            bw.flush();
            return;
        }
        
        // 나머지 프로그램들에 대해, 모든 길이 K의 연속 부분 구간의 해시값(정방향)들을 HashSet에 저장
        // 프로그램 i (i>=1)마다 set[i]에 저장
        @SuppressWarnings("unchecked")
        HashSet<Long>[] hashSets = new HashSet[N];
        for (int i = 1; i < N; i++) {
            int[] arr = programs[i];
            int M = arr.length;
            HashSet<Long> set = new HashSet<>();
            if(M < K){
                // 해당 프로그램에 K 길이의 구간이 없으면 무조건 NO
                bw.write("NO\n");
                bw.flush();
                return;
            }
            // 해당 프로그램의 prefix hash를 미리 계산
            long[] prefix1 = new long[M+1];
            long[] prefix2 = new long[M+1];
            prefix1[0] = 0; prefix2[0] = 0;
            for (int j = 0; j < M; j++) {
                prefix1[j+1] = (prefix1[j] * BASE + arr[j]) % MOD1;
                prefix2[j+1] = (prefix2[j] * BASE + arr[j]) % MOD2;
            }
            for (int start = 0; start <= M - K; start++) {
                int end = start + K - 1;
                long hash1 = (prefix1[end+1] - (prefix1[start] * basePow1[K]) % MOD1 + MOD1) % MOD1;
                long hash2 = (prefix2[end+1] - (prefix2[start] * basePow2[K]) % MOD2 + MOD2) % MOD2;
                long combined = combineHash(hash1, hash2);
                set.add(combined);
            }
            hashSets[i] = set;
        }
        
        // 첫 번째 프로그램에 대한 prefix hash도 계산 (정방향)
        long[] prefixF1 = new long[len0+1];
        long[] prefixF2 = new long[len0+1];
        prefixF1[0] = 0; prefixF2[0] = 0;
        for (int i = 0; i < len0; i++) {
            prefixF1[i+1] = (prefixF1[i] * BASE + prog0[i]) % MOD1;
            prefixF2[i+1] = (prefixF2[i] * BASE + prog0[i]) % MOD2;
        }
        
        // 첫번째 프로그램에서 후보 구간 (길이 K)의 해시값과, 그 구간의 역순 해시값을 구한다.
        // 만약 모든 나머지 프로그램의 set에 candidateForward 혹은 candidateReverse 가 포함되면 YES.
        boolean found = false;
        for (int start = 0; start <= len0 - K; start++) {
            int end = start + K - 1;
            // 정방향 해시
            long candF1 = (prefixF1[end+1] - (prefixF1[start] * basePow1[K]) % MOD1 + MOD1) % MOD1;
            long candF2 = (prefixF2[end+1] - (prefixF2[start] * basePow2[K]) % MOD2 + MOD2) % MOD2;
            long candidateF = combineHash(candF1, candF2);
            
            // 역방향 해시를 직접 계산 (O(K)) – 후보 구간을 뒤에서부터 읽는다.
            long candR1 = 0, candR2 = 0;
            for (int i = end; i >= start; i--) {
                candR1 = (candR1 * BASE + prog0[i]) % MOD1;
                candR2 = (candR2 * BASE + prog0[i]) % MOD2;
            }
            long candidateR = combineHash(candR1, candR2);
            
            boolean ok = true;
            // 나머지 각 프로그램에 대해 검사
            for (int prog = 1; prog < N; prog++) {
                HashSet<Long> set = hashSets[prog];
                // 해당 프로그램에 candidateF 혹은 candidateR가 있어야 함.
                if (!set.contains(candidateF) && !set.contains(candidateR)) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                found = true;
                break;
            }
        }
        
        bw.write(found ? "YES" : "NO");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 두 해시 값을 하나의 long으로 합친다.
    static long combineHash(long h1, long h2) {
        return (h1 << 32) | (h2 & 0xffffffffL);
    }
}