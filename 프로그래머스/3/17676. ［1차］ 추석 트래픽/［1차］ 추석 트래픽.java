import java.util.*;

class Traffic {
    int start;
    int end;
    
    Traffic(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        List<Traffic> t_list = new ArrayList();
        
        for(int i = 0; i < lines.length; i++) {
            // 초로 전환
            int end =(int)((Integer.parseInt(lines[i].substring(11,13)) * 3600
            + Integer.parseInt(lines[i].substring(14,16)) * 60) * 1000
            + Double.parseDouble(lines[i].substring(17,23)) * 1000);
            
            int treat_time = (int)(Double.parseDouble(lines[i].substring(24, lines[i].length() - 1)) * 1000);
            int start = end - treat_time + 1;
            
            t_list.add(new Traffic(start, end));
        }
        
        int cnt = 0;
        
        for(int i = 0; i < t_list.size(); i++) {
            cnt = 1;
            
            for(int j = i + 1; j < t_list.size(); j++){
                if(t_list.get(i).end + 1000 > t_list.get(j).start) cnt++;
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}