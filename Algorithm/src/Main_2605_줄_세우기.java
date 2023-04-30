//#include <iostream>
//#include <algorithm>
//#include <vector>
//using namespace std;
//
//        int main() {
//        ios_base::sync_with_stdio(0);
//        cin.tie(0); cout.tie(0);
//
//        //입력
//        int n,tmp;
//        cin >> n;
//        vector<int>arr(n);
//
//        //문제 해결
//        for (int i = 1; i <= n; i++) {
//        cin >> tmp;
//        arr.insert(arr.begin() + tmp, i);
//        }
//
//        //결과 출력
//        for (int i = n - 1; i >= 0; i--) cout << arr[i] << ' ';
//        }

//cpp to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2605_줄_세우기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            for (int j = i; j > i - tmp; j--) arr[j] = arr[j - 1];

            arr[i - tmp] = i + 1;
        }

        for (int i = 0; i < n; i++) bw.write(arr[i] + " ");
        bw.close();
    }
}