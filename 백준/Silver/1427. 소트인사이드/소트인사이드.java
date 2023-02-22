import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int len = num.length();
        Integer arr[] = new Integer[len];
        for(int i=0; i<len; i++) arr[i] = num.charAt(i) - '0';
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<len; i++) System.out.print(arr[i]);
    }
}