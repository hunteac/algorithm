class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Z")) answer -= Integer.parseInt(arr[i - 1]); // Z가 나오면 바로 전에 더했던 숫자 빼기
            else answer += Integer.parseInt(arr[i]);
        }
        return answer;
    }
}