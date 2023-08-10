import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		for (Integer n : list) {
			sb.append(n).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}