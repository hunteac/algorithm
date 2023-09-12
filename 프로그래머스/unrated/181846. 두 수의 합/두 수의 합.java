import java.util.*;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        String[] aArr = a.split("");
        String[] bArr = b.split("");
        int[] nums = new int[Math.max(aArr.length, bArr.length)];
        int len = nums.length;
        int idx1 = aArr.length - 1;
        int idx2 = bArr.length - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (idx1 >= 0 && idx2 >= 0) nums[i] = Integer.parseInt(aArr[idx1--]) + Integer.parseInt(bArr[idx2--]); // 각 자릿수 더하기
            else if (idx1 >= 0 && idx2 < 0) nums[i] = Integer.parseInt(aArr[idx1--]);
            else if (idx2 >= 0 && idx1 < 0) nums[i] = Integer.parseInt(bArr[idx2--]);
        }
        for (int i = nums.length - 1; i >= 1; i--) { // 자릿수가 10을 초과하면 그 다음 자릿수에 더해준다.
            if (nums[i] >= 10) {
                nums[i - 1] += nums[i] / 10;
                nums[i] %= 10;
            } 
        }
        for (int i = 0; i < nums.length; i++) { // 문자열로 합치기
            answer += String.valueOf(nums[i]);
        }
        return answer;
    }
}