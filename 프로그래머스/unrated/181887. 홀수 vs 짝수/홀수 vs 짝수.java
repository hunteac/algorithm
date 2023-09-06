class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) odd += num_list[i]; // 홀수 번째 원소 총합
            else even += num_list[i]; // 짝수 번째 원소 총합
        }
        return Math.max(odd, even);
    }
}