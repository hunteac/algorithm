import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] room = new ArrayList[path.length + 1]; // 연결 리스트
        List<Integer>[] pre = new ArrayList[path.length + 1]; // 선행 조건 리스트
        boolean[] visited = new boolean[path.length + 1]; // 방문 확인
        boolean[] visit = new boolean[path.length + 1]; // 방문 가능 확인
        
        for (int i = 0; i < room.length; i++) {
            room[i] = new ArrayList<>();
            pre[i] = new ArrayList<>();
            visit[i] = true;
        }
        
        for (int i = 0; i < path.length; i++) {
            int from = path[i][0];
            int to = path[i][1];
            
            // 양방향 연결
            room[from].add(to);
            room[to].add(from);
        }
        
        // 선행 조건이 있는 방들 체크
        for (int i = 0; i < order.length; i++) {
            int before = order[i][0]; // 선행 조건
            int after = order[i][1]; // 조건 달성 후 방문 방
            
            if (after == 0) return false;
            
            pre[before].add(after);
            visit[after] = false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0); // 0번 방 시작
        
        while (!queue.isEmpty()) {
            int curr = queue.poll(); // 현재 방 번호
        
            visited[curr] = true; // 방문 처리
            
            for (int i = 0; i < pre[curr].size(); i++) {
                int next = pre[curr].get(i);
                visit[next] = true; // 선행 조건 완료
                for (Integer con : room[next]) { // 선행 조건을 완료한 방과 연결된 방을 방문했다면 큐에 넣기
                    if (visited[con]) queue.add(next);
                }
            }
            
            for (int i = 0; i < room[curr].size(); i++) {
                int next = room[curr].get(i); // 다음 방문 방
                
                if (visit[next] && !visited[next]) queue.add(next); // 방문할 수 있고, 방문하지 않았다면 큐에 넣기
            }
        }
        
        boolean answer = true; // 모든 방 방문 가능 확인
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}