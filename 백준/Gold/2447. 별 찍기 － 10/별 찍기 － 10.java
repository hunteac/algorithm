import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static char[][] star;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        star = new char[N][N];
        
        printStar(N, 0, 0);
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		sb.append(star[i][j] == '*' ? '*' : ' ');
        	}
        	
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void printStar(int N, int r, int c) {
    	int next = N / 3;
    	
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (next > 0 && !(i == 1 && j == 1)) {
    				printStar(next, r + (next * i), c + (next * j));
    			}
    		}
    	}
    	
    	star[r][c] = '*';
    }
}