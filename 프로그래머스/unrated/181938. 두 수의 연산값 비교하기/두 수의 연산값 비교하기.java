class Solution {
    public int solution(int a, int b) {
        String[] arr = new String[2];
        arr[0] = String.valueOf(a);
        arr[1] = String.valueOf(b);
        int tmpA = Integer.parseInt(arr[0] + arr[1]);
        int tmpB = 2 * a * b;
        int answer = Math.max(tmpA, tmpB);
        return answer;
    }
}