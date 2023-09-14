import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A); // 두 배열 오름차순 정렬
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i]; // A 배열 작은 순서 * B 배열 큰 순서로 더하기
        }
        return answer;
    }
}