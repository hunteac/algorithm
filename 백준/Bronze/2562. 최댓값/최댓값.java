import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int od = 0;
		
		for (int i = 0; i < 9; i++) {
			int[] arr = new int[9];
			int n = sc.nextInt();
			arr[i] = n;
			if (arr[i] > max) {
				max = arr[i];
				od = i + 1;
			} else {
				continue;
			}
		}
		System.out.printf("%d%n%d", max, od);
	}
}