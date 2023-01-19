import java.util.Scanner;

public class Main_1039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		char[] digits = Integer.toString(N).toCharArray();

		int swaps = 0;
		for (int i = 0; i < digits.length - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[j] > digits[maxIndex]) {
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				char temp = digits[i];
				digits[i] = digits[maxIndex];
				digits[maxIndex] = temp;
				swaps++;
			}
		}

		if (swaps > K) {
			System.out.println(-1);
		} else {
			String result = new String(digits);
			System.out.println(Integer.parseInt(result));
		}
	}
}
