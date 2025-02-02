import java.io.*;
import java.util.*;

public class Main {
    static final long INF = (long)1e18; // 충분히 큰 값
    
    static String init;          // 초기 입력 문자열 (F(0))
    static String[] parts;       // S를 '$'로 split한 결과 (parts[0]는 항상 "")
    static int r;                // '$'의 개수 = parts.length - 1
    static long literalSum;      // ∑_{i=1}^{r} |parts[i]|
    
    static String literalForR1;  // r==1일 때, literal 부분 (parts[1])
    
    // F(0)의 길이부터 T단계까지의 길이를 저장 (T는 max 인덱스를 포함할 수 있는 최소 재귀 깊이)
    static ArrayList<Long> lenLevels = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        // 입출력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력 읽기
        init = br.readLine().trim();
        String S = br.readLine().trim();
        long t = Long.parseLong(br.readLine().trim());
        String[] range = br.readLine().trim().split(" ");
        long posMin = Long.parseLong(range[0]);
        long posMax = Long.parseLong(range[1]);
        
        // S를 '$'로 분리 (첫 문자는 항상 '$'이므로 parts[0]는 항상 "")
        parts = S.split("\\$", -1);
        r = parts.length - 1;
        // literalSum = ∑_{i=1}^{r} |parts[i]|
        literalSum = 0;
        for (int i = 1; i < parts.length; i++) {
            literalSum += parts[i].length();
        }
        
        StringBuilder ans = new StringBuilder();
        
        // r == 1인 경우: F(k) = F(0) + k번 parts[1]
        if(r == 1) {
            literalForR1 = parts[1];
            int baseLen = init.length();
            int litLen = literalForR1.length();
            // 전체 길이 = baseLen + t * litLen (주의: t가 클 수 있으므로 INF 처리)
            long totalLen = baseLen + t * (long)litLen;
            for (long pos = posMin; pos <= posMax; pos++) {
                if(pos > totalLen) {
                    ans.append("-");
                } else {
                    if(pos <= baseLen) {
                        ans.append(init.charAt((int) (pos - 1)));
                    } else {
                        long posInLiteral = pos - baseLen; // 1-indexed among 반복된 literal들
                        // 어떤 반복에 속하는지: 사실 모든 반복은 동일하므로
                        int index = (int)((posInLiteral - 1) % litLen);
                        ans.append(literalForR1.charAt(index));
                    }
                }
            }
            bw.write(ans.toString());
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        
        // r >= 2인 경우
        // F(0)의 길이
        long len0 = init.length();
        lenLevels.add(len0);
        // 목표: 최소 max 인덱스를 포함하는 재귀 깊이 T (단, T <= t)
        int T = 0;
        while (lenLevels.get(T) < posMax && T < t) {
            long prev = lenLevels.get(T);
            long curr = r * prev + literalSum;
            if(curr > INF) curr = INF;
            lenLevels.add(curr);
            T++;
        }
        // 만약 t가 T보다 작으면 실제 t를 사용, 아니면 effective level T suffices.
        int effectiveLevel = (int) Math.min(t, T);
        
        // 각 위치에 대해 getChar(effectiveLevel, pos)를 호출
        for (long pos = posMin; pos <= posMax; pos++) {
            char ch = getChar(effectiveLevel, pos);
            ans.append(ch);
        }
        
        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 재귀적으로 F(level)의 pos번째 문자를 구하는 함수.
    // pos는 1-indexed. 만약 pos가 F(level)의 길이보다 크다면 '-'를 리턴.
    static char getChar(int level, long pos) {
        // lenLevels.get(level) : F(level)의 길이
        if(pos > lenLevels.get(level)) return '-';
        if(level == 0) {
            // F(0)는 초기 문자열
            if(pos > init.length()) return '-';
            return init.charAt((int)(pos - 1));
        }
        // F(level) = for i=1 to r: [ F(level-1) + parts[i] ]
        long segmentLen = lenLevels.get(level - 1); // 길이 F(level-1)
        // i: 1 ~ r
        for (int i = 1; i <= r; i++) {
            // 첫 부분: F(level-1)
            if(pos <= segmentLen) {
                return getChar(level - 1, pos);
            }
            pos -= segmentLen;
            // 두번째 부분: literal parts[i]
            int litLen = parts[i].length();
            if(pos <= litLen) {
                return parts[i].charAt((int)(pos - 1));
            }
            pos -= litLen;
        }
        return '-';
    }
}