import java.util.*;

class Solution {
    public class Process implements Comparable<Process> {
        int priority;
        int loc;
        
        Process(int priority, int loc) {
            this.priority = priority;
            this.loc = loc;
        }
        
        @Override
        public int compareTo(Process p) {
            return p.priority - this.priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Queue<Process> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            pq.add(new Process(priority, i));
            q.add(new Process(priority, i));
        }
        
        int cnt = 1;
        
        while (!pq.isEmpty() && !q.isEmpty()) {
            Process pqProcess = pq.poll();
            Process qProcess = q.poll();
            
            int pqPriority = pqProcess.priority;
            int pqLoc = pqProcess.loc;
            int qPriority = qProcess.priority;
            int qLoc = qProcess.loc;
            
            if (pqPriority != qPriority) {
                pq.add(pqProcess);
                q.add(qProcess);
            } else {
                if (location == qLoc) {
                    answer = cnt;
                    break;
                }
                
                cnt++;    
            }
        }
        
        return answer;
    }
}