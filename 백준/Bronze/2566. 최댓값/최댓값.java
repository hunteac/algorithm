import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];
        int max = 0; 
        int idx1 = 0; 
        int idx2 = 0;
        
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		matrix[i][j] = sc.nextInt();
        	}
        }
        
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (matrix[i][j] >= max) {
        			max = matrix[i][j];
        			idx1 = i + 1;
        			idx2 = j + 1;
        		}
        	}
        }
        
        System.out.printf("%d \n%d %d", max, idx1, idx2);
        
    }
}