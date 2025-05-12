import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int idLen = id_list.length;
        int reportLen = report.length; 
        int[] answer = new int[idLen];
        
        // 중복 신고를 제거하는 해시셋 이용
        HashSet<String> reportSet = new HashSet<>();
        
        for (int i = 0; i < reportLen; i++)
        {
            reportSet.add(report[i]);
        }
        
        // 유저별 아이디 인덱스
        HashMap<String, Integer> idIdx = new HashMap<>();
        // 유저별 신고당한 횟수
        HashMap<String, Integer> reportCnt = new HashMap<>();
        // 신고 여부
        boolean[][] reportFlag = new boolean[idLen][idLen];
        
        
        for (int i = 0; i < idLen; i++)
        {
            String id = id_list[i];
            
            idIdx.put(id, i);
            reportCnt.put(id, 0);
        }
        
        for (String reportStr : reportSet)
        {
            String[] report_arr = reportStr.split(" ");
            
            String fromId = report_arr[0];
            String toId = report_arr[1];
            int fromIdx = idIdx.get(fromId);
            int toIdx = idIdx.get(toId);

            if (!reportFlag[fromIdx][toIdx])
            {
                reportCnt.put(toId, reportCnt.get(toId) + 1);    
            }
            
            reportFlag[fromIdx][toIdx] = true;
        }
        
        for (String reportStr : reportSet)
        {
            String[] report_arr = reportStr.split(" ");
            
            String fromId = report_arr[0];
            String toId = report_arr[1];
            
            int cnt = reportCnt.get(toId);
            
            if (cnt >= k)
            {
                answer[idIdx.get(fromId)]++;
            }
        }
        
        return answer;
    }
}