class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split(" ");
        String answer = "";
        int numx = 0; // x항
        int num = 0; // 상수항
        for (int i = 0; i < arr.length; i += 2) {
            String s = "";
            if (arr[i].charAt(0) == 'x') numx += 1; // 계수 1인 x항 더하기
            if (arr[i].length() == 2 && arr[i].charAt(1) == 'x') numx += arr[i].charAt(0) - 48; // 계수 한 자리수(1제외) x항 더하기
            if (arr[i].length() == 3) {
                s = String.valueOf(arr[i].charAt(0)) + String.valueOf(arr[i].charAt(1)); // 계수 두 자리수 x항 더하기
                numx += Integer.parseInt(s);
            } 
            if (arr[i].length() == 1 && arr[i].charAt(0) >= 48 && arr[i].charAt(0) <= 57) num += Integer.parseInt(arr[i]); // 한 자리수 상수항 더하기
            if (arr[i].length() == 2 && arr[i].charAt(1) >= 48 && arr[i].charAt(1) <= 57) num += Integer.parseInt(arr[i]); // 두 자리수 상수항 더하기
        }
        if (numx == 1) answer += "x"; // 계수 1은 생략
        else if (numx > 1) answer += String.valueOf(numx) + "x";
        if (numx != 0 && num != 0) answer += " + ";
        if (num != 0) answer += String.valueOf(num);
        return answer;
    }
}