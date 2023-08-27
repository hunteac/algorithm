import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int[] nums = new int[N + 1]; // 번호
		LinkedList<Integer> line = new LinkedList<>();
		for (int i = 1; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < nums.length; i++) {
			int num = i - nums[i];
			line.add(num, i);
		}
		for (int i : line) {
			if (i != 0) 
				System.out.print(i + " ");
		}
		sc.close();
	}
}