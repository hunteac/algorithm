class Solution {
    public int getStrLength(String str, int len) {
        String result = "";
        String before = "";
        int cnt = 0;
        
        for (int i = 0; i < str.length(); i += len) {
            String s = "";
            
            if (i + len >= str.length()) {
                s = str.substring(i);
                
                if (!before.equals(s)) {
                    if (cnt != 1) {
                        result += cnt;
                    }
                    
                    result += before + s;    
                } else {
                    cnt++;
                    result += cnt + s;
                }
            } else {
                s = str.substring(i, i + len);
                
                if (!"".equals(before) && !before.equals(s)) {
                    if (cnt == 1) {
                        result += before;
                    } else {
                        result += cnt + before;
                    }

                    cnt = 1;
                } else {
                    cnt++;
                }
                
                before = str.substring(i, i + len);
            }
        }
        
        return result.length();
    }
    
    
    public int solution(String s) {
        int answer = s.length() == 1 ? 1 : Integer.MAX_VALUE;
        
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, getStrLength(s, i));
        }
        
        return answer;
    }
}