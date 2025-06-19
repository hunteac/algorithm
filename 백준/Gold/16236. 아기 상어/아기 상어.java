import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pos implements Comparable<Pos> {
        int r;
        int c;
        int size;
        int cnt;
        int time;

        Pos(int r, int c, int size, int cnt, int time) {
           this.r = r;
           this.c = c;
           this.size = size;
           this.cnt = cnt;
           this.time = time;
        }
        
        @Override
        public int compareTo(Pos p) {
        	if (this.time != p.time) return this.time - p.time;
        	if (this.r != p.r) return this.r - p.r;
        	return this.c - p.c;
        }
    }
    
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int startY = 0;
        int startX = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startY = i;
                    startX = j;
                    map[i][j] = 0;
                }
            }
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>();

        pq.add(new Pos(startY, startX, 2, 0, 0));

        int result = 0;

        while (!pq.isEmpty()) {
            Pos p = pq.poll();
            
            int r = p.r;
            int c = p.c;
            int size = p.size;
            int cnt = p.cnt;
            int time = p.time;
            
            // 먹을 수 있는 우선순위 물고기 체크
            int[] fish = getPriorityFish(r, c, size);
            int nextR = fish[0];
            int nextC = fish[1];
            int dist = fish[2];
            
            // 먹을 수 있는 물고기 X = 종료
            if (dist == 0) {
            	result = time;
            	break; 
            }
            
            cnt++;
            
            if (size == cnt) {
            	size++;
            	cnt = 0;
            }
            
            map[nextR][nextC] = 0;
            
            pq.add(new Pos(nextR, nextC, size, cnt, time + dist));
        }

        System.out.println(result);
    }
    
    public static int[] getPriorityFish(int startR, int startC, int size) {
    	PriorityQueue<Pos> pq = new PriorityQueue<>();
    	visited = new boolean[N][N];
    	
    	pq.add(new Pos(startR, startC, size, 0, 0));
    	visited[startR][startC] = true;
    	
    	int[] result = new int[3];

    	while (!pq.isEmpty()) {
    		Pos p = pq.poll();
    		
    		int r = p.r;
    		int c = p.c;
    		int time = p.time;
    		
    		if (map[r][c] != 0 && map[r][c] < size) {
    			result[0] = r;
    			result[1] = c;
    			result[2] = time;
    			return result;
    		}
    		
    		for (int d = 0; d < 4; d++) {
    			int nextR = r + dr[d];
    			int nextC = c + dc[d];
    			
    			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
    			if (map[nextR][nextC] > size || visited[nextR][nextC]) continue;
    			
    			visited[nextR][nextC] = true;
    			pq.add(new Pos(nextR, nextC, size, 0, time + 1));
    		}
    	}
    	
    	return result;
    }
}