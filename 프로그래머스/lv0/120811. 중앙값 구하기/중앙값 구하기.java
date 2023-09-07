import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array); // 오름차순 정렬
        return array[array.length / 2]; // 중앙값 반환
    }
}