import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] board;
	public static boolean[] leftDiag, rightDiag;
	public static int N, max1, max2; 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        leftDiag = new boolean[2 * N];
        rightDiag = new boolean[2 * N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j < N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        max1 = 0;
        max2 = 0;
        
        bishop(0, 0, 0); // 흑
        bishop(0, 1, 0); // 백
        
        System.out.println(max1 + max2);
    }
    
    public static void bishop(int idx, int color, int cnt) {
    	if (idx >= N * N) {
    		if (color == 0) max1 = Math.max(max1, cnt);
    		else max2 = Math.max(max2, cnt);
    		return;
    	}
    
    	int r = idx / N;
    	int c = idx % N;
    	
    	if ((r + c) % 2 == color) {
    		if (board[r][c] == 1 && !leftDiag[r + c] && !rightDiag[r - c + N - 1]) {
    			leftDiag[r + c] = true;
    			rightDiag[r - c + N - 1] = true;
    			bishop(idx + 1, color, cnt + 1);
    			leftDiag[r + c] = false;
    			rightDiag[r - c + N - 1] = false;
    		}
    	}
    	
    	bishop(idx + 1, color, cnt);
    }
}