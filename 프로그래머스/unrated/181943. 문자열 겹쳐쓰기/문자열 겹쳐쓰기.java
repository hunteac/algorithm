class Solution {
    public String solution(String my_string, String overwrite_string, int s) { 
        String bstr = my_string.substring(0, s); // 겹쳐쓰지않는 앞부분
        String estr = my_string.substring(s + overwrite_string.length()); // 겹쳐쓰지않는 뒷부분
        return bstr + overwrite_string + estr;
    }
}