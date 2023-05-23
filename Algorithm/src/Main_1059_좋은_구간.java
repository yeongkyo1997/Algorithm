import java.util.*;

public class Main_1059_좋은_구간 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int L = Integer.parseInt(scanner.nextLine());
        String[] numsStr = scanner.nextLine().split(" ");
        int[] nums = new int[L];
        for (int i = 0; i < L; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int target = Integer.parseInt(scanner.nextLine());

        int[] sortedNums = new int[L + 1];
        System.arraycopy(nums, 0, sortedNums, 0, L);
        sortedNums[L] = 0;
        Arrays.sort(sortedNums);

        int A = 0;
        for (int i = 0; i < sortedNums.length - 1; i++) {
            if (sortedNums[i] == target || sortedNums[i + 1] == target) {
                A = 0;
                break;
            } else if (sortedNums[i] < target && target < sortedNums[i + 1]) {
                A = (target - sortedNums[i]) * (sortedNums[i + 1] - target) - 1;
                break;
            }
        }

        System.out.println(A);
    }
}
