//#include <stdio.h>
//        #include <stdlib.h>
//
//        int array[100001];// array[n]에는 n이랑 연결된 노드 개수 추가
//        int brray[100001];
//
//        typedef struct node
//        {
//        int data;
//        struct node* next;
//        }Node;
//
//        Node* Array[100001];
//
//        void Find(int n)
//        {
//        int i;
//        Node* cur;
//
//        cur = Array[n];
//
//        for (i = 1; i <= array[n]; i++)
//        {
//        cur = cur->next;
//        if (brray[cur->data] == 0)//brray에 저장된게 없으면 처음 만난게 부모 노드
//        {
//        brray[cur->data] = n;//array[n][i]의 부모노드로 n을 추가
//        Find(cur->data);//자식 노드를 찾으러 떠난다.
//        }
//        }
//
//        return;
//        }
//
//        int main()
//        {
//
//        int i, j, N;
//        int x, y;
//        int count = 0;
//        Node* cur;
//
//        scanf("%d", &N);
//
//        for (i = 1; i <= N; i++)
//        {
//        Array[i] = (Node*)malloc(sizeof(Node));
//        Array[i]->next = NULL;
//        }
//
//        for (i = 0; i < N - 1; i++)
//        {
//        scanf("%d %d", &x, &y);
//
//        array[x]++;//array[x]에는 그 성분과 연결된 노드의 개수를 저장
//        cur = Array[x];
//        for (j = 0; j < array[x] - 1; j++)
//        {
//        cur = cur->next;
//        }
//        cur->next = (Node*)malloc(sizeof(Node));
//        cur->next->data = y;
//        cur->next->next = NULL;
//
//        array[y]++;
//        cur = Array[y];
//        for (j = 0; j < array[y] - 1; j++)
//        {
//        cur = cur->next;
//        }
//        cur->next = (Node*)malloc(sizeof(Node));
//        cur->next->data = x;
//        cur->next->next = NULL;
//        }
//
//        Find(1);
//
//        for (i = 2; i <= N; i++)
//        {
//        printf("%d\n", brray[i]);
//        }
//
//
//        return 0;
//        }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//cpp to java
public class Main_11725_트리의_부모_찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] parent;
    static int[][] edges;

    static void find_parent(int n, int[][] edges) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = -1;
        }
        parent[1] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int s = edge[0];
                int e = edge[1];
                if (parent[e] == -1 && parent[s] != -1) {
                    parent[e] = s;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        find_parent(n, edges);

        for (int i = 2; i <= n; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.close();
    }
}