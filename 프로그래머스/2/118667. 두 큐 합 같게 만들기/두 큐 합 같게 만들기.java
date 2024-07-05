import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long s1 = 0;
        long s2 = 0;
        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();
        int result = 0;
        
        for (int i : queue1){
            q1.offer((long)i);
            s1 += i;
        }
        
        for (int i : queue2) {
            q2.offer((long)i);
            s2 += i;
        }
        int flag = 0;
        
        while (!q1.isEmpty() && !q2.isEmpty() && result < 333333) {
            if (s1 == s2) {
                return result;
            }
            else if (s1 > s2) {
                long poll = q1.poll();
                s1 -= poll;
                s2 += poll;
                q2.offer(poll);
                result++;
            }
            else if (s1 < s2) {
                long poll = q2.poll();
                s1 += poll;
                s2 -= poll;
                q1.offer(poll);
                result++;
            }
            else
                break;
        }
        
        return -1;
    }
}