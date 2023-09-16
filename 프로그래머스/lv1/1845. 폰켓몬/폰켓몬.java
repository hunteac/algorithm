import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> phone = new HashSet<>(); // 중복 종류 제거 위한 set 활용
        for (int i = 0; i < nums.length; i++) {
            phone.add(nums[i]);
        }
        if (phone.size() > nums.length / 2) return nums.length / 2;
        else return phone.size();
    } 
}