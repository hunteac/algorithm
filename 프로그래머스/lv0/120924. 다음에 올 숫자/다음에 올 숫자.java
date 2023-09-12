class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int num = 0;
        if (common[2] - common[1] == common[1] - common[0]) { // 등차수열
            num = common[1] - common[0];
            return common[common.length - 1] + num;    
        } 
        else { // 등비수열
            num = common[1] / common[0];
            return common[common.length - 1] * num;
        } 
    }
}