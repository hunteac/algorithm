import java.util.*;

class Solution {
    class Food implements Comparable<Food> {
        int idx;
        int time;
        
        Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
        
        @Override
        public int compareTo(Food o) {
            if (this.time != o.time) {
                return Integer.compare(this.time, o.time);
            }
            return Integer.compare(this.idx, o.idx);
        }
    }
    
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int len = food_times.length;
        
        PriorityQueue<Food> pq = new PriorityQueue<>();
        long sum = 0;
        
        for (int i = 0; i < len; i++) {
            int time = food_times[i];
            sum += time;
            pq.add(new Food(i, time));
        }
        
        if (k >= sum) {
            return -1;
        }
        
        int before = 0;
        
        while (!pq.isEmpty()) {
            Food food = pq.peek();
            int idx = food.idx;
            int time = food.time - before;
            
            if (time == 0) {
                pq.poll();
                continue;
            }
            
            long timeSum = (long) time * pq.size();
            
            if (timeSum > k) {
                ArrayList<Integer> idxList = new ArrayList<>();
                
                while (!pq.isEmpty()) {
                    idxList.add(pq.poll().idx);
                }
                
                Collections.sort(idxList);
                
                int resultIdx = (int) (k %= idxList.size());
                
                answer = idxList.get(resultIdx) + 1;
            } else {
                k -= timeSum;
                pq.remove();
            }
            
            before += time;
        }
        
        
        
        return answer;
    }
}