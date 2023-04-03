import java.math.BigInteger;
import java.util.Scanner;

public class Main_1257_엄청난_부자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger bi = new BigInteger(sc.next());
        BigInteger big = new BigInteger(sc.next());

        System.out.println(bi.divide(big));
        System.out.println(bi.remainder(big));

    }
}