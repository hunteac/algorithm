import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		if (a.equals("M")) {
			System.out.println("MatKor");
		} else if (a.equals("W")) {
			System.out.println("WiCys");
		} else if (a.equals("C")) {
			System.out.println("CyKor");
		} else if (a.equals("A")) {
			System.out.println("AlKor");
		} else if (a.equals("$")) {
			System.out.println("$clear");
		}
	}
}