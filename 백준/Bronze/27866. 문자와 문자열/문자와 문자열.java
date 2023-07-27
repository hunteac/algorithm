import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		String[] strarr = str.split("");
		
		System.out.println(strarr[sc.nextInt() - 1]);
		
	}
}
