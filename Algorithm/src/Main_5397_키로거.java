import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_5397_키로거 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int test_case = Integer.parseInt(br.readLine());
        for (int t = 0; t < test_case; t++) {
            String s = br.readLine();
            Stack<Character> result = new Stack<>();
            Stack<Character> temp = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '<') {
                    if (!result.empty()) temp.push(result.pop());
                } else if (s.charAt(i) == '>') {
                    if (!temp.empty()) result.push(temp.pop());
                } else if (s.charAt(i) == '-') {
                    if (!result.empty()) result.pop();
                } else {
                    result.push(s.charAt(i));
                }
            }

            while (!temp.empty()) result.push(temp.pop());

            StringBuilder answer = new StringBuilder();

            while (!result.empty()) answer.append(result.pop());

            bw.write(answer.reverse() + "\n");
        }
        bw.close();
    }
}