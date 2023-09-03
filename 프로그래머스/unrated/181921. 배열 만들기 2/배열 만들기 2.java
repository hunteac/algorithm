class Solution {
    public int[] solution(int l, int r) {
        int[] tmp = new int[r + 1];
        int cnt = 0;
        int len = 0;
        for (int i = l; i <= r; i++) {
            String s = String.valueOf(i);
            cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0' || s.charAt(j) == '5') cnt++;
            }
            if (cnt == s.length()) {
                tmp[i] = 1;
                len++;
            }
        }
        if (len == 0) len = 1;
        int[] answer = new int[len];
        if (answer.length == 1) {
            answer[0] = -1;  
            return answer;
        } 
        cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 1) answer[cnt++] = i;
        }
        return answer;
    }
}