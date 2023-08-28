import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1제곱미터 당 참외 개수
		LinkedList<Integer> land = new LinkedList<>();
		int[] count = new int[5]; // 이동 방향 횟수
		for(int i = 0; i < 12; i++) {
			land.add(sc.nextInt());
		}
		int cmax = 0; // 가로 최대 길이
		int maxi = 0; // 최대 길이 방향
		int area = 0; // 참외밭 면적
		for (int i = 0; i < 12; i += 2) {
			cmax = Math.max(cmax, land.get(i + 1));
			if (land.get(i + 1) == cmax) { // 가로 최대 길이 구하기
				maxi = land.get(i); // 해당 길이 방향 구하기
			}
			count[land.get(i)]++;
		}
		for (int i = 0; i < 12; i += 2) {
			if (land.peek() != maxi) { // 가로 최대 길이를 리스트 처음으로 옮기기
				int tmpi = land.pop();
				int	tmpv = land.pop();
				land.add(tmpi);
				land.add(tmpv);
			} else
				break;
		}
		// 참외밭 면적 구하기
		if ((maxi == 2 && count[3] == 2) || (maxi == 1 && count[4] == 2) || (maxi == 3 && count[1] == 2) || (maxi == 4 && count[2] == 2)) {
			area = land.get(1) * land.get(11) - land.get(5) * land.get(7); 
		} else {
			area = land.get(1) * land.get(3) - land.get(7) * land.get(9);
		}
		System.out.println(area * N);
	}
}