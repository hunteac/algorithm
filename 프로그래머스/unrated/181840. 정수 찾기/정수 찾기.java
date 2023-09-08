class Solution {
    public int solution(int[] num_list, int n) {
        boolean flag = false;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] == n) flag = true; // num_list에서 n과 동일한 원소를 찾으면 true
        }
        if (flag) return 1;
        else return 0;
    }
}