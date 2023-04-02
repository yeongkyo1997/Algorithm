import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N, K; // 테스트케이스, 숫자의 개수, K번째로 큰 수
    static int[] decimal = new int[28 + 10]; // 16진수를 10진수로 변환한 수를 저장할 배열
    static int dcnt; // decimal 배열의 인덱스
    static final int MAX = 28 + 10; // decimal 배열의 최대 크기

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            dcnt = 0;

            StringBuilder number;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            number = new StringBuilder(br.readLine());

            for (int i = 0; i < N / 4; i++) number.append(number.charAt(i));
            number.setLength(N + N / 4);

            for (int i = 0; i < N; i++) decimal[dcnt++] = makeDecimal(number.substring(i, i + N / 4));

            /*
             * 16진수를 10진수로 변환한 수를 내림차순으로 정렬
             * 중복되는 수는 정렬하지 않음
             */
            for (int i = 0; i < dcnt - 1; i++) {
                for (int k = i + 1; k < dcnt; k++) {
                    if (decimal[i] < decimal[k]) { // 내림차순 정렬
                        int tmp = decimal[i];
                        decimal[i] = decimal[k];
                        decimal[k] = tmp;
                    }
                }
            }

            int[] uniqueList = new int[MAX]; // 중복되지 않은 수를 저장할 배열
            int ucnt = 0; // uniqueList 배열의 인덱스

            uniqueList[ucnt++] = decimal[0]; // 첫번째 수는 무조건 uniqueList에 저장
            for (int i = 1; i < dcnt; i++) { // 중복되지 않은 수만 uniqueList에 저장
                if (decimal[i] == uniqueList[ucnt - 1]) continue; // 이전 수와 같으면 continue

                uniqueList[ucnt++] = decimal[i]; // 다르면 uniqueList에 저장
            }

            bw.write("#" + tc + " " + uniqueList[K - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }

    /*
     * 16진수를 10진수로 변환하는 함수
     */
    static int makeDecimal(String str) {
        int sum, mul; // 10진수로 변환한 수를 저장할 변수, 16진수의 자리수를 저장할 변수

        sum = 0; // 10진수로 변환한 수를 저장할 변수 초기화
        mul = 1; // 16진수의 자리수를 저장할 변수 초기화

        for (int i = str.length() - 1; i >= 0; i--) { // 16진수를 10진수로 변환
            if (str.charAt(i) >= 'A') sum += (str.charAt(i) - 'A' + 10) * mul; // A~F인 경우
            else sum += (str.charAt(i) - '0') * mul; // 0~9인 경우

            mul *= 16; // 16진수의 자리수를 1씩 증가
        }

        return sum;
    }
}