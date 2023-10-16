class Solution {
    boolean[] visited; // 방문 체크
    
    public void DFS (int[][] arr, int r) {
        for (int c = 0; c < arr.length; c++) {
            if (visited[c] || arr[r][c] == 0) continue; // 방문했거나 연결이 안돼있으면 continue
            visited[c] = true; // 방문 처리
            DFS(arr, c); // 재귀 함수 호출
        }
    } 
    
    public int solution(int n, int[][] computers) {
        int answer = 0; // 네트워크 수
        
        visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) { // 방문하지 않은 컴퓨터만
                DFS(computers, i);
                answer++; // 네트워크 수 증가
            }
        }
        
        return answer;
    }
}