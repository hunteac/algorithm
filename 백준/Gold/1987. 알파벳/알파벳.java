import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static char[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int R, C, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[26];
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
        	String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        
        System.out.println(max);
    }
    
    public static void dfs(int r, int c, int dist) {
    	max = Math.max(max, dist);
    	
    	for (int d = 0; d < 4; d++) {
    		int nextR = r + dr[d];
    		int nextC = c + dc[d];
    		if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
    		
    		char next = board[nextR][nextC];
    		
    		if (!visited[next - 'A']) {
    			visited[next - 'A'] = true;
    			dfs(nextR, nextC, dist + 1);
    			visited[next - 'A'] = false;
    		}
    	}
    }
}