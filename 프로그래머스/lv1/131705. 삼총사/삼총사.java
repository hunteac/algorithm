class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) { // 학생1 번호
            for (int j = i + 1; j < number.length - 1; j++) { // 학생2 번호 
                for (int k = j + 1; k < number.length; k++) { // 학생3 번호
                    if (number[i] + number[j] + number[k] == 0) answer++; // 세 학생의 번호를 더했을 때 0이면 삼총사
                }
            }
        }
        return answer;
    }
}