import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 난쟁이 키를 담는 배열 선언
		int[] height = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		// 전체 키 총합에서 두 명의 난쟁이 키를 뺀 후 합 100 구하기
		Outer: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - height[i] - height[j] == 100) {
					height[i] = 0;
					height[j] = 0;
					break Outer;
				}
			}
		}
		// 배열 오름차순 정렬
		Arrays.sort(height);
		for (int i : height) {
			if (i != 0)
				System.out.println(i);
		}
	}
}