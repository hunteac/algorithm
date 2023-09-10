class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] arr = letter.split(" "); // 공백을 기준으로 split
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < morse.length; j++) {
                if (arr[i].equals(morse[j])) { // 동일한 모스부호면
                    answer += (char) (j + 97); // 해당 문자 더하기
                    break;
                } 
            }
        }
        return answer;
    }
}