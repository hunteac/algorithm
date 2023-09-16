class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = 0;
        boolean chk = true;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    num = nums[i] + nums[j] + nums[k]; // 3개 합
                    chk = true;
                    for (int l = 2; l < num; l++) { // 소수 판별
                        if (num % l == 0) {
                            chk = false;
                            break;
                        }    
                    }
                    if (chk) answer++;
                }
            }
        }  
        return answer;
    }
}