class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        int[] start = new int[lines.length];
        int[] end = new int[lines.length];
        
        for (int i = 0; i < lines.length; i++) {
            // 종료 시간 구하기
            String tmp = lines[i].substring(11, 23);
            tmp = tmp.replace(":", "");
            tmp = tmp.replace(".", "");
            
            int endTime = Integer.parseInt(tmp); // 종료 시간 정수화
            
            end[i] = endTime;
            
            int idx = 25;
            
            // 시작 시간 구하기
            tmp = String.valueOf(lines[i].charAt(24)); 
            
            while (lines[i].charAt(idx) != 's') {
                if (lines[i].charAt(idx) != '.') tmp += lines[i].charAt(idx);
                idx++;
            }
            
            if (idx == 25) idx++;
            
            while (idx < 29) {
                tmp += "0";
                idx++;
            }
            
            start[i] = endTime - Integer.parseInt(tmp) + 1;
            
            System.out.println("start : " + start[i]);
            System.out.println("end : " + end[i]);
        }
          
        return answer;
    }
}