import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		int counts[] = new int[8001];
		int i, num, sum=0, min=4000, max=-4000, max_count=0;
		for(i=0; i<size; i++) {
			num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sum += num;
			if( num > max ) max=num;
			if( num < min ) min=num;
			counts[4000+num]++;
			if( counts[4000+num]>max_count ) max_count = counts[4000+num];
		}
		int freq2 = 0, freq_count = 0;
		for(i=min; i<=max && freq_count<2; i++) {
			if( counts[4000+i] != max_count ) continue;
		    freq2 = i;
		    freq_count++;
		}
		Arrays.sort(arr);
		System.out.println( Math.round(1.0D*sum/size) );
		System.out.println( arr[size/2] );
		System.out.println( freq2 );
		System.out.println( max-min );   
	}
}