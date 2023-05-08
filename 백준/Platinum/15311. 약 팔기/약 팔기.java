import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        out.write("2000\n");
        for (int i = 1; i <= 1000; i++) {
            out.write("1 ");
        }
        for (int i = 1000; i >= 1; i--) {
            out.write("1000 ");
        }
        out.flush();
    }
}