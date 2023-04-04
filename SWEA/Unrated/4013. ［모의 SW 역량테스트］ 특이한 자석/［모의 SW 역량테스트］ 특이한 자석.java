import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//cpp to java
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T; // 테스트 케이스의 수
    static int[][] wheel = new int[5][10]; // 자석의 정보를 저장할 배열
    static int[] list = new int[6]; // 자석이 회전해야하는지 확인할 배열
    static int[] number = new int[100]; // 회전시킬 자석의 번호를 저장할 배열
    static int[] dir = new int[100]; // 회전시킬 방향을 저장할 배열
    static int N; // 자석을 회전시킬 횟수

    /*
     * number : 회전시킬 자석의 번호 dir : 회전시킬 방향
     */
    static void rotate(int number, int dir) {
        int tmp; // 자석을 회전시키기 위한 임시 변수

        if (dir == -1) { // 반시계 방향으로 회전
            tmp = wheel[number][1]; // 첫번째 자석을 임시 변수에 저장
            for (int index = 1; index <= 7; index++) { // 두번째 자석부터 마지막 자석까지 한칸씩 앞으로 이동
                wheel[number][index] = wheel[number][index + 1];
            }
            wheel[number][8] = tmp; // 마지막 자석에 첫번째 자석을 저장
        } else { // 시계 방향으로 회전
            tmp = wheel[number][8]; // 마지막 자석을 임시 변수에 저장
            for (int index = 8; index >= 2; index--) { // 마지막 자석부터 두번째 자석까지 한칸씩 뒤로 이동
                wheel[number][index] = wheel[number][index - 1];
            }
            wheel[number][1] = tmp; // 첫번째 자석에 마지막 자석을 저장
        }
    }

    /*
     * compare : 비교할 자석의 번호 number : 회전시킬 자석의 번호
     */
    static int check(int compare, int number) {
        if (compare < 1 || compare > 4) return 0; // 범위를 벗어나면 0을 리턴
        if (number < 1 || number > 4) return 0; // 범위를 벗어나면 0을 리턴

        if (compare < number && wheel[number][7] != wheel[compare][3]) return 1; // 왼쪽 자석이 회전해야하는지 확인   
        if (compare > number && wheel[number][3] != wheel[compare][7]) return 1; // 오른쪽 자석이 회전해야하는지 확인

        return 0; // 회전해야하지 않으면 0을 리턴
    }

    /*
     * number : 회전시킬 자석의 번호 dir : 회전시킬 방향
     */
    static void dfs(int number, int dir) {
        if (check(number - 1, number) == 1 && list[number - 1] == 0) { // 왼쪽 자석이 회전해야하는지 확인
            list[number - 1] = dir * (-1); // 회전해야하면 -1을 곱해서 저장
            dfs(number - 1, dir * (-1)); // dfs로 회전해야할 자석을 찾는다.
        }

        if (check(number + 1, number) == 1 && list[number + 1] == 0) { // 오른쪽 자석이 회전해야하는지 확인
            list[number + 1] = dir * (-1); // 회전해야하면 -1을 곱해서 저장
            dfs(number + 1, dir * (-1)); // dfs로 회전해야할 자석을 찾는다.
        }

    }

    /*
     * 1번 자석이 12시 방향이 S극이면 0, N극이면 1
     * 2번 자석이 12시 방향이 S극이면 0, N극이면 2
     * 3번 자석이 12시 방향이 S극이면 0, N극이면 4
     * 4번 자석이 12시 방향이 S극이면 0, N극이면 8
     * 1, 2, 3, 4번 자석이 12시 방향이 N극이면 15
     */
    static int calculate() {
        int sum, mul; // 2진수로 계산하기 위한 변수
        sum = 0;
        mul = 1;

        for (int i = 1; i <= 4; i++) { // 2진수로 계산
            sum += mul * wheel[i][1]; // 1번 자석이 12시 방향이 N극이면 1, S극이면 0
            mul *= 2; // 2진수로 계산하기 위한 변수
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int result;

            N = Integer.parseInt(br.readLine());

            for (int number = 1; number <= 4; number++) {
                st = new StringTokenizer(br.readLine());
                for (int index = 1; index <= 8; index++) { // 1번 자석부터 8번 자석까지
                    wheel[number][index] = Integer.parseInt(st.nextToken()); // 자석의 정보를 저장
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                number[i] = Integer.parseInt(st.nextToken());
                dir[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                list[number[i]] = dir[i]; // 회전해야할 자석을 저장
                dfs(number[i], dir[i]); // dfs로 회전해야할 자석을 찾는다.

                for (int k = 1; k <= 4; k++)
                    if (list[k] != 0) rotate(k, list[k]); // 찾은 자석을 회전시킨다.

                for (int k = 1; k <= 4; k++) list[k] = 0; // list 초기화
            }

            result = calculate(); // 계산

            bw.write("#" + tc + " " + result + "\n");
        }

        bw.flush();
        bw.close();
    }
}