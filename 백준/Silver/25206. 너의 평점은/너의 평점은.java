import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static float getScore(String grade) {
        if (grade.charAt(0) != 'F') {
            if (grade.charAt(1) == '+') {
                return 'F' - grade.charAt(0) - 0.5f;
            } else if (grade.charAt(1) == '0') {
                return 'F' - grade.charAt(0) - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String grade;
        float hakjum, hakjumSum = 0;
        double allSum = 0;

        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            hakjum = Float.parseFloat(input[1]);
            grade = input[2];
            if (grade.charAt(0) != 'P') {
                hakjumSum += hakjum;
                allSum += hakjum * getScore(grade);
            }
        }
        System.out.printf("%.6f\n", allSum / hakjumSum);

        br.close();
    }
}