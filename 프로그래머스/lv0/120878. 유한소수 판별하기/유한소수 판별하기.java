class Solution {
    public static int getGcd(int i, int j) { // 최대공약수 구하는 메소드
        if (j == 0)
            return i;
        else return getGcd(j, i % j);
    }
    
    public int solution(int a, int b) {
        boolean flag = true;
        boolean[] chk = new boolean[b + 1];
        for (int i = 0; i < chk.length; i++) {
            chk[i] = true;
        }
        int n = getGcd(a, b);
        a /= n; // 기약분수 만들기
        b /= n; // 기약분수 만들기
        for (int i = 2; i <= b; i++) {
            if (!chk[i]) continue;
            if (b % i == 0)
                if (i != 2 && i != 5) flag = false; // 분모의 소인수가 2, 5가 아니라면 false
            for (int j = i * i; j <= b; j += i) { // 에라토스테네스의 체를 활용한 소수 구하기
                chk[j] = false;
            }
        }
        if (flag) return 1; // 분모의 소인수가 2, 5만 존재하면 1 반환
        else return 2; // 아니면 2 반환
        
    }
}