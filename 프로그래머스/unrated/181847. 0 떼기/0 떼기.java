class Solution {
    public String solution(String n_str) {
        String answer = "";
        Outer: for (int i = 0; i < n_str.length(); i++) {
            if (n_str.charAt(i) == '0') continue; // 가장 왼쪽에 연속해서 등장하는 0 떼기
            else {
                for (int j = i; j < n_str.length(); j++) {
                    answer += n_str.charAt(j); // 0이 아닌 문자가 등장하면 모두 더하기
                }
                break Outer;
            }
        }
        return answer;
    }
}