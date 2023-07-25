import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr[i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			for (int j = a - 1; j <= b - 1; j++) {
				arr[j] = c; 
			}	
		}
		
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				System.out.print("0");
				System.out.print(" ");
			} else {
				System.out.print(arr[i]);
				System.out.print(" ");
			}
			
		}
	}
}