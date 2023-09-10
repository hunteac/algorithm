class Solution {
    public int solution(String str1, String str2) {
        boolean flag = false;
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.substring(i, str2.length() + i).equals(str2)) flag = true;
        }
        if (flag) return 1;
        else return 2;
    }
}