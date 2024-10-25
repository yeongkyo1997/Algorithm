import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int nA, nB;
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        TreeSet<Integer> A = new TreeSet<>();
        TreeSet<Integer> B = new TreeSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nA; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        A.removeAll(B);

        if (A.isEmpty())
            bw.write(0 + "");
        else {
            bw.write(A.size() + "\n");
            Iterator it = A.iterator();
            while (it.hasNext())
                bw.write(it.next() + " ");
        }
        bw.close();
    }
}