import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0; // 보트 최솟값
        
        Arrays.sort(people); // 몸무게 오름차순 정렬
        
        int i = 0;
        int j = people.length - 1;
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) { // 두명 태우기
                answer++;
                i++;
                j--;
            } else { // 한명 태우기
                answer++;
                j--;
            }             
        }
        
        return answer;
    }
}