import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		
		if (a.equals("SONGDO")) {
			System.out.println("HIGHSCHOOL");
		} else if (a.equals("CODE")) {
			System.out.println("MASTER");
		} else if (a.equals("2023")) {
			System.out.println("0611");
		} else if (a.equals("ALGORITHM")) {
			System.out.println("CONTEST");
		}
		sc.close();
	}
}