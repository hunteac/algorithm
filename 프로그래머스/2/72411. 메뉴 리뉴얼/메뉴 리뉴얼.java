import java.util.*;

class Solution {
    
    HashMap<String, Integer> countMap = new HashMap<>();
    
    public void getComb(int idx, String comb, String order) {
        String curr;
        
        for (int i = idx; i < order.length(); i++) {
            curr = comb + order.charAt(i);
            
            countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
            
            getComb(i + 1, curr, order);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<Integer> courseSet = new HashSet<>();
        
        for (int i : course) {
            courseSet.add(i);
        }
        
        String tmp;
        
        for (int i = 0; i < orders.length; i++) {
            String[] arr = orders[i].split("");
            Arrays.sort(arr);
            
            tmp = "";
            
            for (int j = 0; j < arr.length; j++) {
                tmp += arr[j];
            }
            
            orders[i] = tmp;
        }
        
        for (String order : orders) {
            getComb(0, "", order);
        }
        
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        
        for (String key : countMap.keySet()) {
            if (countMap.get(key) >= 2 && courseSet.contains(key.length())) {
                if (maxMap.containsKey(key.length())) {
                    maxMap.put(key.length(), Math.max(maxMap.get(key.length()), countMap.get(key)));
                } else {
                    maxMap.put(key.length(), countMap.get(key));
                }
            }
        }
        
        for (String key : countMap.keySet()) {
            if (maxMap.containsKey(key.length()) && countMap.get(key) == maxMap.get(key.length())) {
                list.add(key);
            }
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}