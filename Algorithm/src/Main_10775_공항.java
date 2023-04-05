import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_10775_공항 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int gates;
    static int numAirplanes;
    static int[] airplanes;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        gates = Integer.parseInt(br.readLine());
        numAirplanes = Integer.parseInt(br.readLine());
        airplanes = new int[numAirplanes];
        parent = new int[gates + 1];

        IntStream.range(0, gates + 1).forEach(i -> parent[i] = i);

        for (int i = 0; i < numAirplanes; i++) airplanes[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < numAirplanes; i++) {
            int airplane = airplanes[i];
            int root = find(airplane);
            if (root == 0) break;
            union(root, root - 1);
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }

    static int find(int airplane) {
        int parkingGate = parent[airplane];
        if (parkingGate == airplane) return airplane;
        else return parent[airplane] = find(parkingGate);

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }
}