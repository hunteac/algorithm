class Solution {
    public int solution(int[] num_list) {
        int answer = 1; // 곱하기를 위해 변수 값 1로 지정
        for (int i = 0; i < num_list.length; i++) {
            if (num_list.length >= 11) answer += num_list[i]; // 길이가 11 이상이면 더하기
            else answer *= num_list[i]; // 길이가 10 이하면 곱하기
        }
        if (num_list.length >= 11) return answer - 1; // 초기 설정값 빼기
        else return answer;
    }
}