import java.util.*;

class Solution {
    static int[] sel; // 숫자 선택 배열
    static int answer; // 경우의 수
    static int sum; // 합
    
    // 깊이 우선 탐색 메소드
    static void DFS(int[] arr, int target, int depth){
        sum = 0;
        if (depth == arr.length) {
            for (int n : sel) {
                sum += n;
            }
            if (sum == target) answer++;
            return;
        }
        
        sel[depth] = arr[depth]; // 원소 선택
        DFS(arr, target, depth + 1);
        sel[depth] = - arr[depth]; // 원소 선택 X
        DFS(arr, target, depth + 1);
    }
    
    public int solution(int[] numbers, int target) {
        sel = new int[numbers.length];
        answer = 0;
        
        DFS(numbers, target, 0);
                                                 
        return answer;
    }
}