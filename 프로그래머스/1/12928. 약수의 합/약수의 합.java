import java.util.*;

class Solution {    
    public int solution(int n) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                s.add(i);
                s.add(n / i);
            }
        }
        
        int result = 0;
        for (int num : s) {
            result += num;
        }
        return result;
    }
}