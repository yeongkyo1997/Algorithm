import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 BufferedWriter를 사용하여 입출력을 처리합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄에서 N과 M을 읽습니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 행의 문자열과 그 빈도를 저장할 Map을 선언합니다.
        Map<String, Integer> patternCount = new HashMap<>();

        // 각 행을 입력받으며, 해당 문자열의 등장 횟수를 기록합니다.
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            patternCount.put(row, patternCount.getOrDefault(row, 0) + 1);
        }

        // 마지막 줄에서 K 값을 읽습니다.
        int K = Integer.parseInt(br.readLine());

        int maxOnRows = 0; // 켜져있는 행의 최대 개수를 저장할 변수

        // 각 행의 패턴에 대해 체크합니다.
        for (String pattern : patternCount.keySet()) {
            int zeroCount = 0; // 해당 행에서 꺼져있는 램프(0)의 개수
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '0') {
                    zeroCount++;
                }
            }
            
            // 행을 모두 켜기 위해서는 꺼진 램프의 개수만큼 해당 열 스위치를 눌러야 합니다.
            // 단, 스위치를 누른 총 횟수(K)가 꺼진 램프의 개수보다 크거나 같아야 하며,
            // (K - zeroCount)가 짝수여야 (나머지 스위치 누름들이 모두 짝수번 눌려 원래 상태를 유지) 합니다.
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                // 같은 패턴의 행들이 동시에 켜질 수 있으므로, 그 개수를 최대값과 비교합니다.
                maxOnRows = Math.max(maxOnRows, patternCount.get(pattern));
            }
        }

        // 결과를 출력합니다.
        bw.write(String.valueOf(maxOnRows));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}