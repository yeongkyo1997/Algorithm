import java.util.*;
import java.util.Arrays.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while (true) {
            if (pq.peek() >= K) {
                return result;
            }
            if (pq.size() <= 1)
                break;
            int a = pq.poll();
            
            int b = pq.poll();
            
            pq.offer(mix(a, b));
            result++;
        }
        return -1;
    }
    
    static int mix(int a, int b) {
        return a + b * 2;
    }
}