//#include <iostream>
//#include <string>
//using namespace std;
//
//        int main() {
//        string str;
//
//        getline(cin, str);
//
//        for (int i = 0; i < str.length(); i++) {
//        if (str[i] >= 'A' && str[i] <= 'Z') {
//        if (str[i] - 'A' < 13) {
//        str[i] += 13;
//        }
//        else {
//        str[i] -= 13;
//        }
//        }
//        else if (str[i] >= 'a' && str[i] <= 'z') {
//        if (str[i] - 'a' < 13) {
//        str[i] += 13;
//        }
//        else {
//        str[i] -= 13;
//        }
//        }
//
//        cout << str[i];
//        }
//
//        return 0;
//        }

//cpp to java

import java.io.*;
import java.util.StringTokenizer;

public class Main_11655_ROT13 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                bw.write(str.charAt(i) - 'A' < 13 ? (char) (str.charAt(i) + 13) : (char) (str.charAt(i) - 13));
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                bw.write(str.charAt(i) - 'a' < 13 ? (char) (str.charAt(i) + 13) : (char) (str.charAt(i) - 13));
            else bw.write(str.charAt(i));
        }
        bw.close();
    }
}