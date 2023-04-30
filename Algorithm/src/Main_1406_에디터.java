//string_list = list(input())
//        cursor = len(string_list)
//
//        for _ in range(int(input())):
//        command = list(input().split())
//        if command[0] == 'P':
//        string_list.insert(cursor, command[1])
//        cursor += 1
//
//        elif command[0] == 'L':
//        if cursor > 0:
//        cursor -= 1
//
//        elif command[0] =='D':
//        if cursor < len(string_list):
//        cursor += 1
//
//        else:
//        if cursor > 0:
//        string_list.remove(string_list[cursor-1])
//
//        print(''.join(string_list))

//py3 to java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1406_에디터 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        int point = str.length();

        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "P":
                    sb.insert(point, st.nextToken());
                    point++;
                    break;
                case "L":
                    if (point > 0) {
                        point--;
                    }
                    break;
                case "D":
                    if (point < sb.length()) {
                        point++;
                    }
                    break;
                default:
                    if (point > 0) {
                        sb.deleteCharAt(point - 1);
                        point--;
                    }
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}