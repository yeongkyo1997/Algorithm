//#include <iostream>
//#include <string>
//#include <algorithm> // reverse 함수
//
//using namespace std;
//
//        int n, m;
//        string factorial[101][101];
//
//        string bigNumAdd(string n1, string n2)
//        {
//        int sum = 0;
//        string result;
//
//        // 1의 자리부터 더하기
//        while (!n1.empty() || !n2.empty() || sum)
//        {
//        if (!n1.empty())
//        {
//        sum += n1.back() - '0';
//        n1.pop_back();
//        }
//        if (!n2.empty())
//        {
//        sum += n2.back() - '0';
//        n2.pop_back();
//        }
//        result.push_back((sum % 10) + '0');
//        sum /= 10;
//        }
//
//        // 1의 자리부터 push 했으므로 뒤집어준다.
//        reverse(result.begin(), result.end());
//        return result;
//        }
//
//        string combination(int n, int r)
//        {
//        if (n == r || r == 0)
//        return "1";
//        string &result = factorial[n][r]; // 참조형 변수
//
//        // 이미 계산했으면 바로 return, memoization 기법
//        if (result != "")
//        return result;
//
//        // 파스칼삼각형 원리 이용
//        result = bigNumAdd(combination(n - 1, r - 1), combination(n - 1, r));
//        return result;
//        }
//
//        void input()
//        {
//        ios_base::sync_with_stdio(false);
//        cin.tie(NULL);
//        cout.tie(NULL);
//
//        cin >> n >> m;
//        }
//
//        int main()
//        {
//        //input 받기
//        input();
//        // 조합 구하기
//        cout << combination(n, m);
//
//        return 0;
//        }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// CPP to java
public class Main_2407_조합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, m;
    static String[][] factorial = new String[101][101];

    static String bigNumAdd(String n1, String n2) {
        int sum = 0;
        StringBuilder result = new StringBuilder();

        while (!n1.isEmpty() || !n2.isEmpty() || sum != 0) {
            if (!n1.isEmpty()) {
                sum += n1.charAt(n1.length() - 1) - '0';
                n1 = n1.substring(0, n1.length() - 1);
            }
            if (!n2.isEmpty()) {
                sum += n2.charAt(n2.length() - 1) - '0';
                n2 = n2.substring(0, n2.length() - 1);
            }
            result.insert(0, (sum % 10));
            sum /= 10;
        }
        return result.toString();
    }

    static String combination(int n, int r) {
        if (n == r || r == 0) {
            return "1";
        }
        String result = factorial[n][r];

        if (result != null) {
            return result;
        }

        result = bigNumAdd(combination(n - 1, r - 1), combination(n - 1, r));
        return result;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bw.write(combination(n, m));
        bw.flush();
        bw.close();
    }
}