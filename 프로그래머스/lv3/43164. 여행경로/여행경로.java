import java.util.*;

class Solution {
    static HashMap<String, String> map; // 최종 도착 지점을 판별하기 위한 HashMap
    static boolean[] visited; // 방문 체크

    static void Travel(int cnt, int idx, String[] answer, String[][] tickets) {
        // 여행 끝
        if (cnt == tickets.length) {
            answer[cnt] = tickets[idx][1];
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] || !tickets[i][0].equals(tickets[idx][1])) continue;
            // 여행이 끝난 상태면 return
            if (answer[answer.length - 1] != null && answer[cnt].compareTo(tickets[i][0]) >= 0) return;
            visited[i] = true;
            answer[cnt] = tickets[i][0];
            Travel(cnt + 1, i, answer, tickets);
            visited[i] = false;
        }
        return;
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        map = new HashMap<>();
        int start = 0; // 시작 지점

        // 경로 알파벳 순서로 정렬
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        
        // 최종 도착 지점 구하기
        for (int i = 0; i < tickets.length; i++) {
            map.put(tickets[i][0], tickets[i][1]);
        }
        
        // 시작 지점 찾기
        for (int i = 0; i < tickets.length; i++) {
            // 최종 도착 지점 제외
            if (!map.containsKey(tickets[i][1])) continue;
            if (tickets[i][0].equals("ICN")) {
                start = i;
                break;
            }
        }

        answer[0] = tickets[start][0];
        visited[start] = true; // 방문 처리

        Travel(1, start, answer, tickets); // 여행 시작

        return answer;
    }
}