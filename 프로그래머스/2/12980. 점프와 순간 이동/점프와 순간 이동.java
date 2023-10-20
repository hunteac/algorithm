import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n > 0) {
            if (n % 2 == 1) ans++; // 홀수일 때 배터리 사용
            n /= 2;
        }

        return ans;
    }
}