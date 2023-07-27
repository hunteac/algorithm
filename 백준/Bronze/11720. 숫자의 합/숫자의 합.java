import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		String[] arrstr = str.split("");
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(arrstr[i]);
		}
		
		System.out.println(sum);
		
		sc.close();
	} 
	
}
