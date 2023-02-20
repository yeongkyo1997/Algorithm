import java.util.Scanner;
import java.util.Arrays;
public class Main {
    private static int getPopulation(int k, int n) {
        if( k == 0 ) return n;
        int population = 0;
        for(int i=1; i<=n; i++) {
            population += getPopulation(k-1, i);
        }
        return population;
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] counts = new int[9];
	    
	    String str = String.valueOf(n);
	    char[] nums = str.toCharArray();
	    
	    for(int i=0; i<nums.length; i++) {
	        int temp = nums[i] - '0';
	        if( temp == 9 ) temp = 6;
	        counts[temp]++;
	    }
        counts[6] = (int) Math.ceil(counts[6] / 2.0);
	    
	    int max = 0;
	    for( int i=0; i<counts.length; i++ ) {
	        if( counts[i] > max ) max = counts[i];
	    }
	    System.out.println( max );
	}
}