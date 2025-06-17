import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static char[][] star;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        star = new char[N][N * 2 - 1];
        
        printStar(N, 0, N - 1);
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < star[i].length; j++) {
        		sb.append(star[i][j] == '*' ? '*' : ' ');
        	}
        	
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void printStar(int N, int r, int c) {
    	int next = N / 2;
    	
    	if (next != 1) {
    		printStar(next, r       , c       );
    		printStar(next, r + next, c - next);
    		printStar(next, r + next, c + next);
    	} else {
    		for (int i = r; i < r + 3; i++) {
    			for (int j = c - (i - r); j <= c + (i - r); j++) {
    				if (i == r + 1 && j == c) continue;
    				star[i][j] = '*';
    			}
    		}
    	}
    }
}