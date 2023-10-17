import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0; // 최대 승점
        
        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B);
    
        int min = 0; // 최솟값
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] < B[min]) { // 최솟값이 A팀의 수보다 크면 최솟값 사용
                answer++; // 승점 +1
                min++;
            } else if (A[i] >= B[min]) { // 최솟값이 A팀의 수보다 작거나 같으면 A팀의 수보다 큰 수 찾기
                while (min < B.length) {
                    if (B[min] > A[i]) {
                        answer++;
                        min++;
                        break;    
                    } 
                    
                    min++;
                }
            }
            if (min == B.length) break; // 더 이상 A팀의 수보다 큰 수가 없으면 종료
        }
        
        return answer;
    }
}