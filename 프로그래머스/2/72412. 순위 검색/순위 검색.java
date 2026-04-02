import java.util.*;

class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public void getMap(int idx, String info, String[] infoArr) {
        // 종료
        if (idx == infoArr.length - 1) {
            ArrayList<Integer> list = map.getOrDefault(info, new ArrayList<>());
            list.add(Integer.parseInt(infoArr[idx]));
            map.put(info, list);
            return;
        }
        
        // 실행
        if (idx == infoArr.length - 2) {
            getMap(idx + 1, info + "-", infoArr);
            getMap(idx + 1, info + infoArr[idx], infoArr);
        } else {
            getMap(idx + 1, info + "- ", infoArr);
            getMap(idx + 1, info + infoArr[idx] + " ", infoArr);
        }
    }
    
    public int getCount(String target, int score) {
        if (!map.containsKey(target)) {
            return 0;
        }
        
        ArrayList<Integer> list = map.get(target);
        
        int left = 0;
        int right = list.size();
        int mid;
        
        while (left < right) {
            mid = (left + right) / 2;
            
            if (list.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return list.size() - right;
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        
        for (int i = 0; i < info.length; i++) {
            String[] infoArr = info[i].split(" ");
            getMap(0, "", infoArr);
        }
        
        // 리스트 오름차순 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < query.length; i++) {
            String tmp = query[i].replace(" and", "");
            String[] queryArr = tmp.split(" ");
            
            String target = "";
            for (int j = 0; j < queryArr.length - 1; j++) {
                if (j < queryArr.length - 2) {
                    target += queryArr[j] + " ";
                } else {
                    target += queryArr[j];
                }
            }
            
            list.add(getCount(target, Integer.parseInt(queryArr[queryArr.length - 1])));
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}