import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] sarr = s.split(" ");
		
		int cnt = 0;
		for (int i = 0; i < sarr.length; i++) {
			if (!(sarr[i].equals(""))) cnt++;
		}
		System.out.println(cnt);
	
	}   
	
}
