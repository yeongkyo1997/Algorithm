import java.util.Scanner;
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
	    int T = sc.nextInt();
		for (int i=0; i<T; i++) {
		    int k = sc.nextInt();
		    int n = sc.nextInt();
	        System.out.println( getPopulation(k,n) );
		}
	}
}