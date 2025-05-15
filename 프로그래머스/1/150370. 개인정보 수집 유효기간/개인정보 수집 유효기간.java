import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termsMap = new HashMap<>();
        
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            
            termsMap.put(term[0], Integer.parseInt(term[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            
            int period = termsMap.get(privacy[1]);
            
            if (getDate(today, 0) >= getDate(privacy[0], period)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer -> Integer).toArray();
    }
    
    public int getDate(String date, int period) {
        int[] dateArr = Arrays.stream(date.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int year = dateArr[0];
        int month = dateArr[1] + period;
        int day = dateArr[2];
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}