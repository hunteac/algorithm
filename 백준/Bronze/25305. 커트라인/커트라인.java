import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] stu = new int[sc.nextInt()];
		int prz = sc.nextInt();
		
		for (int i = 0; i < stu.length; i++) {
			stu[i] = sc.nextInt();
		}
		Arrays.sort(stu);
		System.out.println(stu[stu.length- prz]);
		sc.close();
	}
}
