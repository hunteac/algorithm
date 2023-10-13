import java.util.*;

class Solution {
    public int solution(int n) {
        int next = n + 1;
        
        int len = Integer.toBinaryString(n).replace("0", "").length(); // 이진 변환 후 1의 개수 구하기
        int comp = 0; // 비교
                
        while (true) {
            comp = Integer.toBinaryString(next).replace("0", "").length();    
            
            if (comp == len) break; // 1의 개수가 같으면 종료
            
            next++;
        }

        return next;
    }
}