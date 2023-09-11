import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        int[] count = new int[1000]; // 빈도수를 구하기 위한 배열
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++; // 빈도수 구하기
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = i; // 최빈값
            }
        }
        Arrays.sort(count);
        if (count[999] == count[998]) return -1; // 최빈값이 여러개인 경우 -1 반환
        else return answer;
    }
}