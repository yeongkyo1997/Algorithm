//#include <iostream>
//#include <stack>
//using namespace std;
//
//        int main() {
//        int N;
//        cin >> N;
//
//        int ans = 0;
//        while (N--) {
//        stack<char> stack;
//        string word;
//        cin >> word;
//
//        for (int i = 0; i < word.length(); i++) {
//        if (stack.empty()) {
//        stack.push(word[i]);
//        }
//        else {
//        if (stack.top() == word[i]) {
//        stack.pop();
//        }
//        else {
//        stack.push(word[i]);
//        }
//        }
//        }
//
//        if (stack.empty()) {
//        ans++;
//        }
//        }
//
//        cout << ans;
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3986_좋은_단어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String word = br.readLine();

            for (int i = 0; i < word.length(); i++) {
                if (!stack.empty()) {
                    if (stack.peek() == word.charAt(i)) stack.pop();
                    else stack.push(word.charAt(i));
                } else stack.push(word.charAt(i));
            }
            if (stack.empty()) result++;
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}