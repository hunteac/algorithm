import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder sb;
	public static int[][] tree;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        tree = new int[N][N];

        for (int i = 0; i < N; i++) {
        	String s = br.readLine();
        	for (int j = 0; j < N; j++) {
        		tree[i][j] = s.charAt(j) - '0';
        	}
        }
        
        compressTree(N, 0, 0);
        
        System.out.println(sb);
    }
    
    public static void compressTree(int N, int r, int c) {
    	int num = tree[r][c];
    	int next = N / 2;
    	
    	for (int i = r; i < r + N; i++) {
    		for (int j = c; j < c + N; j++) {
    			if (tree[i][j] != num) {
    				sb.append("(");
    				
    				for (int k = 0; k < 2; k++) {
    					for (int l = 0; l < 2; l++) {
    						compressTree(next, r + (next * k), c + (next * l));
    					}
    				}
    				
    				sb.append(")");
    				
    				return;
    			}
    		}
    	}
    	
    	sb.append(num);
    }
}