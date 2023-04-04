//#include <iostream>
//#include <algorithm>
//#include <vector>
//
//#define endl "\n"
//        #define MAX 1000010
//        using namespace std;
//
//        int N;
//        int Arr[MAX];
//        int Index_Arr[MAX];
//        vector<int> V;
//
//        void Input()
//        {
//        cin >> N;
//        for (int i = 1; i <= N; i++)
//        {
//        cin >> Arr[i];
//        }
//        }
//
//        void Solution()
//        {
//        for (int i = 1; i <= N; i++)
//        {
//        if (V.size() == 0 || V[V.size() - 1] < Arr[i])
//        {
//        V.push_back(Arr[i]);
//        Index_Arr[i] = V.size() - 1;
//        }
//        else
//        {
//        int Left = 0;
//        int Right = V.size() - 1;
//        while (Left < Right)
//        {
//        int Mid = (Left + Right) / 2;
//
//        if (V[Mid] >= Arr[i]) Right = Mid;
//        else Left = Mid + 1;
//        }
//        V[Left] = Arr[i];
//        Index_Arr[i] = Left;
//        }
//        }
//        cout << V.size() << endl;
//        vector<int> Answer;
//        int Find_Index = V.size() - 1;
//        for (int i = N; i > 0; i--)
//        {
//        if (Index_Arr[i] == Find_Index)
//        {
//        Find_Index--;
//        Answer.push_back(Arr[i]);
//        }
//        }
//        for (int i = Answer.size() - 1; i >= 0; i--) cout << Answer[i] << " ";
//        cout << endl;
//        }
//
//        void Solve()
//        {
//        Input();
//        Solution();
//        }
//
//        int main(void)
//        {
//        ios::sync_with_stdio(false);
//        cin.tie(NULL);
//        cout.tie(NULL);
//
//        //freopen("Input.txt", "r", stdin);
//        Solve();
//
//        return 0;
//        }


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_14003_가장_긴_증가하는_부분_수열_5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[] idxArr;
    static int[] V;
    static int[] result;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        idxArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        IntStream.rangeClosed(1, N).forEach(i -> arr[i] = Integer.parseInt(st.nextToken()));

        V = new int[N + 1];
        result = new int[N + 1];

        int vSize = 0;

        for (int i = 1; i <= N; i++) {
            if (vSize == 0 || V[vSize] < arr[i]) {
                V[++vSize] = arr[i];
                idxArr[i] = vSize;
            } else {
                int left = 1;
                int right = vSize;
                while (left < right) {
                    int Mid = (left + right) / 2;
                    if (V[Mid] >= arr[i]) right = Mid;
                    else left = Mid + 1;
                }
                V[left] = arr[i];
                idxArr[i] = left;
            }
        }

        bw.write(vSize + "\n");

        int fIdx = vSize;
        for (int i = N; i > 0; i--) {
            if (idxArr[i] == fIdx) {
                fIdx--;
                result[fIdx + 1] = arr[i];
            }
        }
        for (int i = 1; i <= vSize; i++)
            bw.write(result[i] + " ");

        bw.write("\n");
        bw.close();
    }
}