//import sys
//input=sys.stdin.readline
//        def makeTable(temp):
//        table=[0]*k
//        i=0
//        for j in range(1,k):
//        while i>0 and temp[i]!=temp[j]:
//        i=table[i-1]
//        if temp[i]==temp[j]:
//        i+=1
//        table[j]=i
//        return table
//
//        def KMP(string,find,temp):
//        i=0
//        for j in range(len(string)):
//        while i>0 and string[j]!=find[i]:
//        i=temp[i-1]
//        if string[j]==find[i]:
//        if i==k-1:
//        return 1
//        else:
//        i+=1
//        return 0
//
//        n,k=map(int,input().split())
//        data=[]
//        for _ in range(n):
//        __=int(input())
//        data.append(list(input().split()))
//
//        for z in range(len(data[0])-k+1):
//        t=makeTable(data[0][z:z+k])
//        for m in range(1,n):
//        can=KMP(data[m],data[0][z:z+k],t)
//        if not can:
//        can=KMP(data[m][::-1],data[0][z:z+k],t)
//        if not can:
//        break
//        if m==n-1:
//        print('YES')
//        sys.exit()
//        print('NO')
//
//
//
//        #FIND사용
//
//import sys
//input=sys.stdin.readline
//
//        n,k=map(int,input().split())
//        data=[]
//        for _ in range(n):
//        __=int(input())
//        data.append(list(input().split()))
//
//        for z in range(len(data[0])-k+1):
//        t=data[0][z:z+k]
//        for m in range(1,n):
//        can=''.join(data[m]).find(''.join(data[0][z:z+k]))
//        if can==-1:
//        can = ''.join(data[m][::-1]).find(''.join(data[0][z:z + k]))
//        if can==-1:
//        break
//        if m==n-1:
//        print('YES')
//        sys.exit()
//        print('NO')

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_7575_바이러스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n, k;
    static String[] text;
    static int[] table;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        text = new String[n];

        for (int i = 0; i < n; i++) {
            br.readLine();
            text[i] = br.readLine();
        }

        for (int i = 0; i < text[0].length() - k + 1; i++) {
            table = getPi(text[0].substring(i, i + k));
            for (int j = 1; j < n; j++) {
                if (KMP(text[j], text[0].substring(i, i + k), table) == 0) {
                    if (KMP(new StringBuilder(text[j]).reverse().toString(), text[0].substring(i, i + k), table) == 0) {
                        break;
                    }
                }
                if (j == n - 1) {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }
        System.out.println("NO");
    }

    static int[] getPi(String tmp) {
        int[] table = new int[k];
        int i = 0;
        for (int j = 1; j < k; j++) {
            while (i > 0 && tmp.charAt(i) != tmp.charAt(j)) {
                i = table[i - 1];
            }
            if (tmp.charAt(i) == tmp.charAt(j)) {
                i++;
            }
            table[j] = i;
        }
        return table;
    }

    static int KMP(String string, String find, int[] temp) {
        int i = 0;
        for (int j = 0; j < string.length(); j++) {
            while (i > 0 && string.charAt(j) != find.charAt(i)) {
                i = temp[i - 1];
            }
            if (string.charAt(j) == find.charAt(i)) {
                if (i == k - 1) {
                    return 1;
                } else {
                    i++;
                }
            }
        }
        return 0;
    }
}