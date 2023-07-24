import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = n / 4;
		String str = "long";
		
		for (int i = 0; i < num; i++) {
			System.out.printf("%s ", str);
		}
		
		System.out.println("int");
	}
}