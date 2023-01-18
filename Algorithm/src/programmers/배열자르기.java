package programmers;

import java.util.Arrays;

public class 배열자르기 {
	public static int[] solution(int[] numbers, int num1, int num2) {
		return Arrays.copyOfRange(numbers, num1, num2 + 1);
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6 }, 1, 3));
	}
}