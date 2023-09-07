class Solution {
    public int solution(String binomial) {
        String[] tmp = binomial.split(" "); // 공백을 기준으로 자르기
        int A = Integer.parseInt(tmp[0]);
        int B = Integer.parseInt(tmp[2]);
        if (tmp[1].equals("+")) return A + B;
        else if (tmp[1].equals("-")) return A - B;
        else if (tmp[1].equals("*")) return A * B;
        else return A / B;
    }
}