import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		String s = sc.next();
		
		for (int i = 0; i < s.length(); i++) {
			list.add((char) s.charAt(i) + "");
		}
		
		for (int i = 0; i < list.size() - 2; i++) {
			if (list.get(i).contains("d") && list.get(i + 1).contains("z") && 
				list.get(i + 2).contains("=")) {
				list.remove(i + 1);
				list.remove(i + 1);
			}
		}
		
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i).contains("="))
				list.remove(i);
		}
		
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i).contains("-"))
				list.remove(i);
		}

		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i).contains("j") && list.get(i - 1).equals("l"))
				list.remove(i);
			else if (list.get(i).contains("j") && list.get(i - 1).equals("n"))
				list.remove(i);
		}
		
		System.out.println(list.size());
		
	}
}
