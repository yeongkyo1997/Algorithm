import java.io.*;
import java.util.*;

public class Main {
    static int K;           // 목표로 하는 서로 다른 숫자의 개수
    static int L;           // N의 자릿수
    static int[] sDigits;   // N의 각 자리 숫자를 저장한 배열
    static int[] ans;       // 재귀로 구한 답 (N과 같은 자릿수)
    static int[] ans2;      // 재귀로 구한 답 (자릿수를 늘려야 할 경우)
    
    // N과 같은 자릿수에서 N 이상이면서 조건을 만족하는 수를 만드는 재귀 함수
    // i: 현재 처리중인 자리, tight: 지금까지 N의 자리와 일치했는지 여부,
    // mask: 지금까지 사용한 숫자들의 비트마스크 (bit d가 1이면 d를 사용)
    static boolean solve(int i, boolean tight, int mask) {
        if(i == L) {
            // 모든 자리를 채운 후, 사용한 숫자의 개수가 K개여야 함
            return Integer.bitCount(mask) == K;
        }
        // 남은 자리수(L-i)마다 최대 한 개씩 새로운 숫자를 쓸 수 있으므로
        // 현재까지 사용한 숫자 개수 + (L-i)가 K보다 작으면 더 이상 불가능
        if(Integer.bitCount(mask) + (L - i) < K) return false;
        
        // 현재 자리는 tight이면 N의 해당 자리 이상, 아니면 0부터 선택
        int lower = (tight ? sDigits[i] : 0);
        // 첫 자리라면 0은 올 수 없으므로 lower bound를 1로 맞춤
        if(i == 0 && lower == 0) lower = 1;
        
        for (int d = lower; d <= 9; d++) {
            int newMask = mask;
            if((mask & (1 << d)) == 0) {
                newMask |= (1 << d);
            }
            if(Integer.bitCount(newMask) > K) continue; // 이미 K개 초과면 skip
            boolean newTight = (tight && (d == sDigits[i]));
            ans[i] = d;
            if(solve(i + 1, newTight, newMask))
                return true;
        }
        return false;
    }
    
    // 자릿수를 늘려서 답을 구할 때 사용하는 재귀 함수.
    // len: 새로 구성할 전체 자리수
    static boolean solve2(int i, int mask, int len) {
        if(i == len) {
            return Integer.bitCount(mask) == K;
        }
        if(Integer.bitCount(mask) + (len - i) < K) return false;
        
        // 첫 자리면 0이 아니어야 하므로
        int lower = (i == 0 ? 1 : 0);
        for (int d = lower; d <= 9; d++) {
            int newMask = mask;
            if((mask & (1 << d)) == 0) {
                newMask |= (1 << d);
            }
            if(Integer.bitCount(newMask) > K) continue;
            ans2[i] = d;
            if(solve2(i + 1, newMask, len))
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        // 입력: N와 K (N은 10^18 이하, K는 10 이하의 자연수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String Nstr = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        L = Nstr.length();
        
        // N을 각 자리 숫자로 분리하여 배열에 저장 (문자열의 앞자리가 가장 높은 자리)
        sDigits = new int[L];
        for (int i = 0; i < L; i++) {
            sDigits[i] = Nstr.charAt(i) - '0';
        }
        
        ans = new int[L];
        // 우선 N과 같은 자릿수에서 조건을 만족하는 수가 있는지 찾음
        if(solve(0, true, 0)) {
            StringBuilder sb = new StringBuilder();
            for (int d : ans)
                sb.append(d);
            bw.write(sb.toString());
        } else {
            // 만약 같은 자릿수에서 답을 찾지 못하면 자릿수를 늘려서 구함.
            // (N의 자릿수가 K보다 작을 수도 있으므로, newLen는 max(L+1, K))
            int newLength = (L < K ? K : L + 1);
            ans2 = new int[newLength];
            solve2(0, 0, newLength);
            StringBuilder sb = new StringBuilder();
            for (int d : ans2)
                sb.append(d);
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}