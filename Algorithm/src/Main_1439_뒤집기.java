import java.io.*;

public class Main_1439_뒤집기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        int start = 0;
        int end = 0;

        do {
            while (end < str.length() && str.charAt(start) == str.charAt(end)) end++;
            start = end;
        } while (end != str.length());
        bw.write("Animal      Count\n" + "-----------------\n" + "Chickens      100\n" + "Clydesdales     5\n" + "Cows           40\n" + "Goats          22\n" + "Steers          2");
        bw.close();
    }
}
