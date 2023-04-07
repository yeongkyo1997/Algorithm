//#include <bits/stdc++.h>
//        using namespace std;
//
//        int main() {
//        cin.tie(0)->sync_with_stdio(0);
//
//        int N, s;
//        cin >> N >> s;
//
//        random_device rd;
//        mt19937_64 mte(rd());
//        vector<int> rp1, rp2;
//        for (int i = 1; i <= N; i++) {
//        rp1.push_back(i);
//        rp2.push_back(i);
//        }
//        shuffle(rp1.begin(), rp1.end(), mte);
//        shuffle(rp2.begin(), rp2.end(), mte);
//
//        int arr[26]{};
//        arr[0] = rp1[0];
//        int id1 = 1, p;
//        for (int i = 1; i < N; i++) {
//        bool find = false;
//        for (int j = 0; j < id1; j++) {
//        cout << "? A " << arr[j] << " A " << rp1[i] << endl;
//        cin >> p;
//        if (p) {
//        find = true;
//        break;
//        }
//        }
//        if (!find)	arr[id1++] = rp1[i];
//        if (id1 > 25)	break;
//        }
//
//        int arr2[26]{};
//        arr2[0] = rp2[0];
//        int id2 = 1;
//        for (int i = 1; i < N; i++) {
//        bool find = false;
//        for (int j = 0; j < id2; j++) {
//        cout << "? B " << arr2[j] << " B " << rp2[i] << endl;
//        cin >> p;
//        if (p) {
//        find = true;
//        break;
//        }
//        }
//        if (!find)	arr2[id2++] = rp2[i];
//        if (id2 > 25)	break;
//        }
//
//        for (int i = 0; i < id1; i++) {
//        for (int j = 0; j < id2; j++) {
//        cout << "? A " << arr[i] << " B " << arr2[j] << endl;
//        cin >> p;
//        if (p) {
//        cout << "! 1" << endl;
//        return 0;
//        }
//        }
//        }
//        cout << "! 0";
//        return 0;
//
//        }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//cpp to java
public class Main_27917_보석_감정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[26];
        int[] arr2 = new int[26];

        int id1 = 0;
        int id2 = 0;

        for (int i = 0; i < N; i++) {
            int p = query('A', i + 1, 'A', i + 1);
            if (p == 1) {
                arr[id1++] = i + 1;
                if (id1 > 25) break;
            }
        }

        for (int i = 0; i < N; i++) {
            int p = query('B', i + 1, 'B', i + 1);
            if (p == 1) {
                arr2[id2++] = i + 1;
                if (id2 > 25) break;
            }
        }

        for (int i = 0; i < id1; i++) {
            for (int j = 0; j < id2; j++) {
                int p = query('A', arr[i], 'B', arr2[j]);
                if (p == 1) {
                    bw.write("! 1");
                    return;
                }
            }
        }
        bw.write("! 0");
    }

    static int query(char a, int x, char b, int y) throws Exception {
//        System.out.println("? " + a + " " + x + " " + b + " " + y);
        bw.write("? " + a + " " + x + " " + b + " " + y + "\n");
        bw.flush();
        st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
}
