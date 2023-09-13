import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String num = "";
        int[] nums = new int[String.valueOf(n).length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(n).charAt(i) - '0';
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) { // 큰 수부터 정렬하기
            num += String.valueOf(nums[i]);
        }
        return Long.parseLong(num);
    }
}