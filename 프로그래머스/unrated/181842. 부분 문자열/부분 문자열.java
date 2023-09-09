class Solution {
    public int solution(String str1, String str2) {
        boolean flag = false;
        for (int i = 0; i <= str2.length() - str1.length(); i++) {
            if (str2.substring(i, str1.length() + i).equals(str1)) // 부분문자열이라면 true
                flag = true;
        }
        if (flag) return 1;
        else return 0;
    }
}