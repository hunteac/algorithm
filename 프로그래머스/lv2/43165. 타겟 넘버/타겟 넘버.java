import java.util.*;

class Solution {
    static boolean[] visited; // 방문 체크
    static int answer; // 경우의 수
    static int sum; // 합
    
    // 재귀 함수
    static void recursion(int[] arr, int target, int idx){
        sum = 0;
        if (idx == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) sum += arr[i]; // 선택한 원소 더하기
                else sum -= arr[i]; // 선택하지 않은 원소 빼기
            }
            if (sum == target) answer++;
            return ;
        }
        
        visited[idx] = true; // 원소 선택
        recursion(arr, target, idx + 1);
        visited[idx] = false; // 원소 선택 X
        recursion(arr, target, idx + 1);
    }
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        answer = 0;
        
        recursion(numbers, target, 0); // 재귀 함수 호출       
                                                 
        return answer;
    }
}