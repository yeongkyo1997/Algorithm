import java.util.Scanner;
public class Main {
	static boolean is_prime(int n) {
		if( n < 2 ) return false;
		if( n < 4 ) return true;
		if( n%2==0 || n%3==0 ) return false;
		for(int i=5; i*i<=n; i+=6 ) if(n%i==0 || n%(i+2)==0) return false;
		return true;
	}
	static int[] get_goldbach_partitions(int n) {
		int sum, left, right;
		left = right = n/2;
		while( 1<left && right<n ) {
			if( !is_prime(left) ) { left--; continue; }
			if( !is_prime(right) ) { right++; continue; }
			sum = left + right;
			if( sum == n ) break;
			if( sum < n ) right++;
			else left--;
		}
		return new int[] {left, right};
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int[] arr = get_goldbach_partitions( sc.nextInt() );
			System.out.printf("%d %d\n", arr[0], arr[1] );
		}
	}
}