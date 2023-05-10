import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());


        Medal[] medals = new Medal[n];
        int targetCountry = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medals[i] = new Medal(country, gold, silver, bronze);
            if (medals[i].country == k) {
                targetCountry = i;
            }
        }

        int rank = 0;

        for (int i = 0; i < n; i++) {
            if (i != targetCountry) {
                if (medals[i].gold > medals[targetCountry].gold) {
                    rank++;
                } else if (medals[i].gold == medals[targetCountry].gold) {
                    if (medals[i].silver > medals[targetCountry].silver) {
                        rank++;
                    } else if (medals[i].silver == medals[targetCountry].silver) {
                        if (medals[i].bronze > medals[targetCountry].bronze) {
                            rank++;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(rank + 1));
        bw.close();
    }
}

class Medal {
    int country;
    int gold;
    int silver;
    int bronze;

    public Medal(int country, int gold, int silver, int bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}