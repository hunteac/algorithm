import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] arr = s.split("");
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(0) > 64 && arr[i].charAt(0) < 68)
				sum += 3;
			else if (arr[i].charAt(0) > 67 && arr[i].charAt(0) <71)
				sum += 4;
			else if (arr[i].charAt(0) > 70 && arr[i].charAt(0) < 74)
				sum += 5;
			else if (arr[i].charAt(0) > 73 && arr[i].charAt(0) < 77)
				sum += 6;
			else if (arr[i].charAt(0) > 76 && arr[i].charAt(0) < 80)
				sum += 7;
			else if (arr[i].charAt(0) > 79 && arr[i].charAt(0) < 84)
				sum += 8;
			else if (arr[i].charAt(0) > 83 && arr[i].charAt(0) < 87)
				sum += 9;		
			else if (arr[i].charAt(0) > 86 && arr[i].charAt(0) < 91)
				sum += 10;			
		}
		System.out.println(sum);
		
	}
	
}
