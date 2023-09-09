class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i].equals(s2[j])) answer++; // s1의 원소와 s2의 원소가 동일하다면 + 1
            }
        }
        return answer;
    }
}