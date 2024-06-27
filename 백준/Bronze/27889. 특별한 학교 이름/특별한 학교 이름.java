import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
        
		if(n.equals("NLCS")) {
			System.out.println("North London Collegiate School");
		}else if(n.equals("BHA")) {
			System.out.println("Branksome Hall Asia");
		}else if(n.equals("KIS")) {
			System.out.println("Korea International School");
		}else if(n.equals("SJA")) {
			System.out.println("St. Johnsbury Academy");
		}
	}
}