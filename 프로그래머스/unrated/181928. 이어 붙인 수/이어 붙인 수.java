class Solution {
    public int solution(int[] num_list) {
        String A = "";
        String B = "";
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 != 0) A += String.valueOf(num_list[i]);
            else B += String.valueOf(num_list[i]);
        }
        return Integer.parseInt(A) + Integer.parseInt(B);
    }
}