import java.util.*;

class Solution {
    class Process {
        int priority;
        int location;
        
        Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(priorities[i], i));
        }
        
        while (!queue.isEmpty()) {
            Process curr = queue.poll();
            
            if (queue.stream().anyMatch(others -> curr.priority < others.priority)) {
                queue.add(curr);
            } else {
                answer++;
                if (location == curr.location) {
                    break;
                }
            }
        }
        
        return answer;
    }
}