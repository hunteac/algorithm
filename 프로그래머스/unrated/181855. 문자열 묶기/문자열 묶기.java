import java.util.Arrays;

class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[31]; // 원소 길이 별 등장 횟수를 구하는 배열 선언
        for (int i = 0; i < strArr.length; i++) {
            count[strArr[i].length()]++; // strArr의 원소 길이 등장 횟수 구하기
        }
        Arrays.sort(count); // 오름차순 정렬
        return count[30]; // 최대 개수 반환
    }
}