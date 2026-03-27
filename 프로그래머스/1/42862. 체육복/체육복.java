import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = lost.length;
        
        Arrays.sort(lost);
        
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        
        for (int i = 0; i < lost.length; i++) {
            lostSet.add(lost[i]);
        }
        
        for (int i = 0; i < reserve.length; i++) {
            if (!lostSet.contains(reserve[i])) {
                reserveSet.add(reserve[i]);
            } else {
                lostSet.remove(reserve[i]);
            }
        }

        for (int i = 0; i < lost.length; i++) {
            int lostNum = lost[i];
            
            if (!lostSet.contains(lostNum)) {
                answer--;
                continue;
            }
            
            if (reserveSet.contains(lostNum - 1)) {
                answer--;
                reserveSet.remove(lostNum - 1);
                continue;
            }
            
            if (reserveSet.contains(lostNum + 1)) {
                answer--;
                reserveSet.remove(lostNum + 1);
            }
        }
        
        return n - answer;
    }
}