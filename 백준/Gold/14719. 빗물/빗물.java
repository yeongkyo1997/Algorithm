import java.util.Scanner;

public class Main {
    
    public static int trappedWater(int h, int w, int[] blocks) {
        int[] leftMax = new int[w];
        int[] rightMax = new int[w];

        leftMax[0] = blocks[0];
        rightMax[w - 1] = blocks[w - 1];

        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blocks[i]);
        }

        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blocks[i]);
        }

        int trappedWaterAmt = 0;

        for (int i = 1; i < w - 1; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            trappedWaterAmt += Math.max(0, minHeight - blocks[i]);
        }

        return trappedWaterAmt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int w = scanner.nextInt();

        int[] blocks = new int[w];
        for (int i = 0; i < w; i++) {
            blocks[i] = scanner.nextInt();
        }

        int result = trappedWater(h, w, blocks);
        System.out.println(result);

        scanner.close();
    }
}