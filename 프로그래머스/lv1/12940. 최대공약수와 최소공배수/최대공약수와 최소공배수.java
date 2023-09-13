class Solution {
    public int getGcd(int i, int j) { // 최대공약수 구하는 메서드
        if (j == 0) return i;
        else return getGcd(j, i % j);
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int num = Math.max(n, m);
        answer[0] = getGcd(n, m);
        while (num % n != 0 || num % m != 0) { // 최소공배수 구하기
            num++;
        }
        answer[1] = num;
        return answer;
    }
}