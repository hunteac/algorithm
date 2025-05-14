import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<String, Integer> score = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++)
        {
            String left = survey[i].substring(0, 1);
            String right = survey[i].substring(1);
            int choice = choices[i];
            
            if (choice == 4) continue;
            
            if (choice > 4)
            {
                score.put(left, score.getOrDefault(left, 0) + (4 - choice));
            }
            else
            {
                score.put(right, score.getOrDefault(right, 0) + (choice - 4));
            }
        }
        
        answer += score.getOrDefault("R", 0) >= score.getOrDefault("T", 0) ? "R" : "T";
        answer += score.getOrDefault("C", 0) >= score.getOrDefault("F", 0) ? "C" : "F";
        answer += score.getOrDefault("J", 0) >= score.getOrDefault("M", 0) ? "J" : "M";
        answer += score.getOrDefault("A", 0) >= score.getOrDefault("N", 0) ? "A" : "N";
        
        return answer;
    }
}