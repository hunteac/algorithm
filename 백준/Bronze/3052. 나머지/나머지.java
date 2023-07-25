import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int[] re = new int[10];
		
		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			arr[i] = n;			
		}
		
		int a = 0;
		for (int i = 0; i < 10; i++) {
			a = arr[i] % 42;
			re[i] = a;
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (re[i] == re[j]) {
					re[j] = re[0];
				}
			}
		}
		
		int b = 1;
		for (int i = 0; i < 9; i++) {
			if (re[0] != re[i + 1]) {
				b += 1;
			}
		}
		System.out.println(b);
		
	}
}