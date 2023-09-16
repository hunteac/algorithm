class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] chk = new boolean[n + 1];
        for (int i = 2; i < chk.length; i++) {
            chk[i] = true;
        }
        for (int i = 2; i < chk.length; i++) {
            if (chk[i]) answer++; // 소수 구하기
            if (!chk[i]) continue; // 소수가 아니면 continue
            for (int j = i * 2; j < chk.length; j += i) { // 에라토스테네스의 체 활용
                chk[j] = false;   
            }
        }
        return answer;
    }
}