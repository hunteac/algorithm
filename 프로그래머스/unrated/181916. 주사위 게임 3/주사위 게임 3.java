class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] check = new int[]{ a, b, c, d };
        int cnt = 0;
        int cnt2 = 0;
        int p = 0;
        int q = 0;
        int r = 0;
        boolean chk = false;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (check[i] == check[j]) {
                    p = check[i]; // p 구하기
                    cnt++;  
                } 
            }
        }
        for (int i = 0; i < 4; i++) {
            if (p != check[i]) {
                q = check[i]; // q 구하기
                cnt2++;
            } 
        }
        for (int i = 0; i < 4; i++) {
            if (p != check[i] && q != check[i]) r = check[i]; // r 구하기
        }
        if (cnt == 6) return 1111 * a; // 모든 숫자가 동일
        else if (cnt == 3 && cnt2 == 1) return (10 * p + q) * (10 * p + q); // 3개 숫자만 동일
        else if (cnt == 3 && cnt2 == 3) return (10 * q + p) * (10 * q + p); // 3개 숫자만 동일
        else if (cnt == 2) return (p + q) * (Math.abs(p - q)); // 2, 2개 숫자 동일
        else if (cnt == 1) return q * r; // 2개 숫자만 동일, 나머지 다름
        else { // 모든 숫자 다름
            int min1 = Math.min(a, b);
            int min2 = Math.min(c, d);
            return Math.min(min1, min2); // 4개 숫자 중 가장 작은 수 구하기
        }
    }
}