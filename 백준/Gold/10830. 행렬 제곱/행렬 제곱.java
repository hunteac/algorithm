import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int[][] matrix = new int[N][N];
        int[][] result = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        result = recur(matrix, B);
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		System.out.print(result[i][j] % 1000 + " ");
        	}
        	System.out.println();
        }
    }
    
    public static int[][] recur(int[][] matrix, long power) {
    	if (power == 1) return matrix;
    	
    	int[][] result = new int[N][N];
    	
    	if (power % 2 == 0) {
    		result = recur(matrix, power / 2);
    		result = matrixPower(result, result);
    	} else  {
    		result = recur(matrix, power - 1);
    		result = matrixPower(result, matrix);
    	}
    	
    	return result;
    }
   
    public static int[][] matrixPower(int[][] A, int[][] B) {
    	int[][] result = new int[N][N];

    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			int num = 0;
    			for (int k = 0; k < N; k++) {
    				num += A[i][k] * B[k][j];
    			}
    			
    			result[i][j] = num % 1000;
    		}
    	}
    	
    	return result;
    }
}