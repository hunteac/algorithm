import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for (int test_case = 0; test_case < a; test_case++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			System.out.println(b + c);
		}
	}
}