import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[30];
		
		for (int i = 0; i < 30; i++) {
			arr[i] = i + 1;
		}
		
		for (int i = 0; i < 28; i++) {
			int num = sc.nextInt();
			if (num == arr[num - 1]) {
				arr[num - 1] = 0;
			} else {
				System.out.println(arr[i]);
			}
		}
		
		for (int i = 0; i < 30; i++) {
			if (arr[i] == 0) {
				continue;
			} else {
				System.out.println(arr[i]);
			}
				
		}
		
	}
}