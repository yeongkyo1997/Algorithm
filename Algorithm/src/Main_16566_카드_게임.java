import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_16566_카드_게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M, K;
    static int[] cards, targets;
    static int anInt;
    static int[] cardsPresence, dummy;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cards = new int[M];
        targets = new int[K];

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, M).forEach(i -> cards[i] = Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        IntStream.range(0, K).forEach(i -> targets[i] = Integer.parseInt(st.nextToken()));

        anInt = (int) Math.sqrt(N);
        cardsPresence = new int[N + 1];
        dummy = new int[anInt + 1];

        for (int c : cards) {
            cardsPresence[c] += 1;
            dummy[c / anInt] += 1;
        }

        for (int t : targets) {
            int will = t + 1;

            while (dummy[will / anInt] == 0 && will <= N) will = ((will / anInt) + 1) * anInt;

            if (will > N) will = 0;

            while (dummy[will / anInt] == 0 && will <= N) will = ((will / anInt) + 1) * anInt;

            while (true) {
                if (cardsPresence[will] != 0) {
                    cardsPresence[will] -= 1;
                    dummy[will / anInt] -= 1;
                    bw.write(will + "\n");
                    break;
                }

                will += 1;
            }
        }
        bw.close();
    }
}

