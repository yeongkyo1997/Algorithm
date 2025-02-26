class Solution {
    public double solution(int[] arr) {
        double result = 0;
        
        for (int a : arr) {
            result += a;
        }
        
        return result / arr.length;
    }
}