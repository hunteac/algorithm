class Solution {
    public int solution(int n) {
        boolean flag = false;
        int num = 1;
        while (num * num <= n) {
            if (num * num == n) flag = true;
            num++;
        }
        if (flag) return 1;
        else return 2;
    }
}