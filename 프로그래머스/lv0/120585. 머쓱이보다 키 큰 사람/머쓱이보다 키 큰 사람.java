class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) answer++; // 키 큰 사람 수 구하기
        }
        return answer;
    }
}