import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] room;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, T, r1, r2;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        room = new int[R][C];
        
        for (int i = 0; i < R; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < C; j++) {
        		room[i][j] = Integer.parseInt(st.nextToken());
        		if (room[i][j] == -1) {
        			if (r1 == 0) r1 = i;
        			else r2 = i;
        		}
        	}
        }
        
        for (int i = 0; i < T; i++) {
        	int[][] clone = new int[R][C];
        	
        	for (int r = 0; r < R; r++) {
        		clone[r] = room[r].clone();
        	}
        	
        	for (int r = 0; r < R; r++) {
        		for (int c = 0; c < C; c++) {
        			if (room[r][c] == -1 || room[r][c] == 0) continue;
        			spreadDust(clone, r, c);
        		}
        	}
        	
        	clean(r1, 0); // 시계방향
        	clean(r2, 0); // 반시계방향
        }
        
        int dust = 0;
        
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		if (room[i][j] != -1) dust += room[i][j];
        	}
        }
        
        System.out.println(dust);
    }
    
    public static void spreadDust(int[][] clone, int r, int c) {
    	for (int d = 0; d < 4; d++) {
			int nextR = r + dr[d];
			int nextC = c + dc[d];
			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || room[nextR][nextC] == -1) continue;
			
			room[r][c] -= clone[r][c] / 5;
			room[nextR][nextC] += clone[r][c] / 5;
			
			room[r][c] = room[r][c] < 0 ? 0 : room[r][c];
		}
    }
    
    public static void clean(int currR, int currC) {
    	int[] dirR;
    	int[] dirC;
    	
    	if (currR == r1) {
    		dirR = new int[]{0, -1, 0, 1};
    		dirC = new int[]{1, 0, -1, 0};
    	} else {
    		dirR = new int[]{0, 1, 0, -1};
    		dirC = new int[]{1, 0, -1, 0};
    	}
    	
    	int dir = 0;
    	int before = 0;
    	
    	int r = currR;
    	int c = currC;
    	
    	while (true) {
    		int nr = r + dirR[dir];
    		int nc = c + dirC[dir];
    		
    		if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
    			dir++;
    			continue;
    		}
    		
    		if (room[nr][nc] == -1) break;
    		
    		int tmp = room[nr][nc];
    		room[nr][nc] = before;
    		before = tmp;
    		
    		r = nr;
    		c = nc;
    	}
    }
}