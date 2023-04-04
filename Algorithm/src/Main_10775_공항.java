import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10775_공항 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int num_gates;
    static int num_airplanes;
    static int[] airplanes;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        num_gates = Integer.parseInt(br.readLine());
        num_airplanes = Integer.parseInt(br.readLine());
        airplanes = new int[num_airplanes];
        parent = new int[num_gates + 1];
        for (int i = 0; i < num_gates + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < num_airplanes; i++) {
            airplanes[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < num_airplanes; i++) {
            int airplane = airplanes[i];
            int root = find(airplane);
            if (root == 0) {
                break;
            }
            union(root, root - 1);
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }

    static int find(int airplane) {
        int parking_gate = parent[airplane];
        if (parking_gate == airplane) {
            return airplane;
        } else {
            return parent[airplane] = find(parking_gate);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }
}