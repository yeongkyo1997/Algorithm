import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17478 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

        String[] str = new String[n];
        solve(0, n, str);

    }

    static void solve(int depth, int n, String[] str) throws IOException {
        StringBuilder underbar = new StringBuilder();
        for (int i = 0; i < depth; i++)
            underbar.append("____");

        if (depth == n) {
            System.out.println(underbar + "\"재귀함수가 뭔가요?\"");
            System.out.println(underbar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(underbar + "라고 답변하였지.");
            return;
        }

        System.out.println(underbar + "\"재귀함수가 뭔가요?\"");
        System.out.println(underbar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(underbar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(underbar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        solve(depth + 1, n, str);
        System.out.println(underbar + "라고 답변하였지.");

    }
}