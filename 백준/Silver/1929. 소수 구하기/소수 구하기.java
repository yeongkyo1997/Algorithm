import java.util.Scanner;
public class Main {
	static boolean is_prime(int n) {
		if( n < 2 ) return false;
		if( n < 4 ) return true;
		if( n%2==0 || n%3==0 ) return false;
		for(int i=5; i*i<=n; i+=6 ) if(n%i==0 || n%(i+2)==0) return false;
		return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		for(int i=M; i<=N; i++) {
			if( is_prime(i) ) System.out.println(i);
		}
	}
}