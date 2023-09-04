class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        if (x1 || x2) x1 = true; // 합집합
        else x1 = false;
        if (x3 || x4) x3 = true; // 합집합
        else x3 = false;
        if (x1 && x3) x1 = true; // 교집합
        else x1 = false;
        return x1;
    }
}