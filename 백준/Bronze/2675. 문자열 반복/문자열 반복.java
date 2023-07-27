import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		
		for (int i = 0; i < TestCase; i++) {
			int r = sc.nextInt();
			String s = sc.next();
			String[] str = s.split("");
			
			
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < r; k++) {
					System.out.print(str[j]);
				}
			}
			System.out.println();
		}
		
	} 
	
}