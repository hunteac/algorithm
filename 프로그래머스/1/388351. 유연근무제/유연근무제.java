class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++)
        {
            int schedule = schedules[i];
            int scheduleH = schedule / 100;
            int currday = startday;
            boolean chk = true;
            
            for (int j = 0; j < timelogs[i].length; j++)
            {
                int timelog = timelogs[i][j];
                int timelogH = timelogs[i][j] / 100;
                
                if (currday >= 6 || (scheduleH > timelogH))
                {
                    currday %= 7;
                    currday++;
                    continue;
                }
                
                int diff = scheduleH < timelogH ? (timelog - schedule - 40) : (timelog - schedule);
                
                if (diff > 10)
                {
                    chk = false;
                    break;
                }
                
                currday++;
            }
            
            if (chk) answer++;
        }
        
        return answer;
    }
}