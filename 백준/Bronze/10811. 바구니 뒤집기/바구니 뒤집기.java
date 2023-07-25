import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] b = new int[sc.nextInt()];
		for (int i = 0; i < b.length; i++) {
			b[i] = i + 1;
		}
		
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int l = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;
			while (l < r) {
				int temp = b[l];
				b[l] = b[r];
				b[r] = temp;
				l++;
				r--;
			}
		}
		
		for (int answer : b) {
			System.out.print(answer + " ");
		}
		
		sc.close();
	}
}
