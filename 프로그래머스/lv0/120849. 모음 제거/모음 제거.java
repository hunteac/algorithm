class Solution {
    public String solution(String my_string) {
        String[] arr = { "a", "e", "i", "o", "u" };
        for (int i = 0; i < arr.length; i++) {
            my_string = my_string.replace(arr[i], ""); // 모음 공백으로 변환
        }
        return my_string;
    }
}