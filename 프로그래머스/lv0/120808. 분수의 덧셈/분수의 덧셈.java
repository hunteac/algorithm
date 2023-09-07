class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int numer = numer1 * denom2 + numer2 * denom1; // 분자
        int denom = denom1 * denom2; // 분모
        int min = Math.min(numer, denom); // 기약분수를 만들기 위한 최대공약수 구하기
        while (min > 1) {
            if (numer % min == 0 && denom % min == 0) { // 최대공약수를 찾으면 기약분수 만들기
                numer /= min;
                denom /= min;
            }
            min--;
        }
        answer[0] = numer;
        answer[1] = denom;
        return answer;
    }
}