import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int idx = 1;
        List<String> results = new ArrayList<>();
        for (int i = 0; i < dartResult.length(); i++) {
            if (i + 1 < dartResult.length() && dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                results.add("10");
                i++;
                continue;
            }
            results.add(String.valueOf(dartResult.charAt(i)));
        }
        int len = results.size();
        while (idx < len) {
            int score = Integer.parseInt(results.get(idx - 1));
            if (results.get(idx).equals("S")) { // S = 1제곱
                if (idx + 1 < len && results.get(idx + 1).equals("*")) {
                    if (idx + 4 < len && results.get(idx + 4).equals("*")) answer += score * 4;
                    else answer += score * 2;
                    idx += 3;
                } else if (idx + 1 < len && results.get(idx + 1).equals("#")) { 
                    if (idx + 4 < len && results.get(idx + 4).equals("*")) answer += score * -2;
                    else answer += score * -1;
                    idx += 3;
                } else {
                    if (idx + 3 < len && results.get(idx + 3).equals("*")) answer += score * 2;
                    else answer += score;
                    idx += 2;
                }       
            } else if (results.get(idx).equals("D")) { // D = 2제곱
                if (idx + 1 < len && results.get(idx + 1).equals("*")) {
                    if (idx + 4 < len && results.get(idx + 4).equals("*")) answer += (int) Math.pow(score, 2) * 4;
                    else answer += (int) Math.pow(score, 2) * 2;
                    idx += 3;
                } else if (idx + 1 < len && results.get(idx + 1).equals("#")) { 
                    if (idx + 4 < len && results.get(idx + 4).equals("*")) answer += (int) Math.pow(score, 2) * -2;
                    else answer += (int) Math.pow(score, 2) * -1;
                    idx += 3;
                } else {
                    if (idx + 3 < len && results.get(idx + 3).equals("*")) answer += (int) Math.pow(score, 2) * 2;
                    else answer += (int) Math.pow(score, 2);
                    idx += 2;
                }   
            } else { // T = 3제곱
                if (idx + 1 < len && results.get(idx + 1).equals("*")) {
                    if (idx + 4 < len && results.get(idx + 4).equals("*")) answer += (int) Math.pow(score, 3) * 4;
                    else answer += (int) Math.pow(score, 3) * 2;
                    idx += 3;
                } else if (idx + 1 < len && results.get(idx + 1).equals("#")) { 
                    if (idx + 4 < len && results.get(idx + 4).equals("*")) answer += (int) Math.pow(score, 3) * -2;
                    else answer += (int) Math.pow(score, 3) * -1;
                    idx += 3;
                } else {
                    if (idx + 3 < len && results.get(idx + 3).equals("*")) answer += (int) Math.pow(score, 3) * 2;
                    else answer += (int) Math.pow(score, 3);
                    idx += 2;
                }   
            }
        }
        return answer;
    }
}