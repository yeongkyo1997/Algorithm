import java.io.*;

public class Main_15311_약_팔기 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        bw.write("2000\n");
        for (int i = 1; i <= 1000; i++) {
            bw.write("1 ");
        }
        for (int i = 1000; i >= 1; i--) {
            bw.write("1000 ");
        }
        bw.close();
    }
}
