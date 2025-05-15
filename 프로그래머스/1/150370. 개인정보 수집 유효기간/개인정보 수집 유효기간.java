import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] todayArr = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Integer> termsMap = new HashMap<>();
        
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            String type = term[0];
            String period = term[1];
            
            termsMap.put(type, Integer.parseInt(period));
        }
        
        List<Integer> nums = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String date = privacy[0];
            String type = privacy[1];
            
            int[] dateArr = Arrays.stream(date.split("\\.")).mapToInt(Integer::parseInt).toArray();
            int period = termsMap.get(type);
            
            dateArr[0] += (dateArr[1] + period - 1) / 12; 
            dateArr[1] = (dateArr[1] + period) % 12 == 0 ? 12 : (dateArr[1] + period) % 12;
            
            if (todayArr[0] > dateArr[0]) {
                nums.add(i + 1);
            } else if (todayArr[0] == dateArr[0]) {
                if (todayArr[1] > dateArr[1]) {
                    nums.add(i + 1);
                } else if (todayArr[1] == dateArr[1]) {
                    if (todayArr[2] >= dateArr[2]) {
                        nums.add(i + 1);
                    }
                }
            }
        }
        
        int[] answer = Arrays.stream(nums.toArray(new Integer[nums.size()])).mapToInt(Integer::intValue).toArray();;
        
        return answer;
    }
}