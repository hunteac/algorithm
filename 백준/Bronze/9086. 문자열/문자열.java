import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TestCase = sc.nextInt();
		
		for (int i = 0; i < TestCase; i++) {
			String str = sc.next();
			String[] strarr = str.split("");
			System.out.println(strarr[0] + strarr[strarr.length - 1]);
		}
		
	}
}
