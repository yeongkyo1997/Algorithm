package programmers;

public class 피자나눠먹기3 {

	public static int solution(int slice, int n) {
		return (int) Math.ceil(n / (double) slice);
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 12));
	}
}
