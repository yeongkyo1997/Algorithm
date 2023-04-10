import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16172_나는_친구가_적다_Large {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String sentence = br.readLine();
        String key = br.readLine();

        sentence = sentence.replaceAll("[0-9]", "");

        bw.write(sentence.contains(key) ? "1" : "0");
        bw.flush();
    }
}
