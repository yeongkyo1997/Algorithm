import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_8980_택배 {

    private static int N;
    private static int C;
    private static int M;
    private static int point;
    private static int loaded;
    private static int delivered;
    private static int[][] parcel;
    private static ArrayList<int[]> loaded_parcel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        delivered = 0;
        parcel = new int[M][3];
        loaded_parcel = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            parcel[i][0] = Integer.parseInt(st.nextToken());
            parcel[i][1] = Integer.parseInt(st.nextToken());
            parcel[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(parcel, Comparator.comparingInt(o -> o[0]));

        for (point = 1; point <= N; point++) {

            ArrayList<Integer> hit_parcel = new ArrayList<>();
            for (int idx = 0; idx < loaded_parcel.size(); idx++) {
                if (loaded_parcel.get(idx)[0] == point) {
                    delivered += loaded_parcel.get(idx)[1];
                    hit_parcel.add(idx);
                }
            }

            for (int idx = hit_parcel.size() - 1; idx >= 0; idx--) loaded_parcel.remove((int) hit_parcel.get(idx));


            for (int[] item : parcel) {
                if (item[0] == point) {
                    loaded_parcel.add(new int[]{item[1], item[2]});
                }
            }

            loaded_parcel.sort(Comparator.comparingInt(o -> o[0]));

            loaded = 0;
            for (int idx = 0; idx < loaded_parcel.size(); idx++) {
                loaded += loaded_parcel.get(idx)[1];
                if (loaded > C) {
                    loaded_parcel.get(idx)[1] -= (loaded - C);
                    if (loaded_parcel.get(idx)[1] == 0) {
                        loaded_parcel = new ArrayList<>(loaded_parcel.subList(0, idx));
                        break;
                    }
                } else {
                    loaded_parcel = new ArrayList<>(loaded_parcel.subList(0, idx + 1));
                    break;
                }
            }
        }
        bw.write(delivered + "");
        bw.close();
    }
}