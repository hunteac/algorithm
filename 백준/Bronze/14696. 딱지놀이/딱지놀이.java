import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 라운드 수
		for (int tc = 1; tc <= T; tc++) {
			int[] A = new int[5]; // A가 가지고 있는 딱지
			int[] B = new int[5]; // B가 가지고 있는 딱지
			int anum = sc.nextInt(); // A가 가지고 있는 딱지 수
			for (int i = 0; i < anum; i++) {
				A[sc.nextInt()]++;
			}
			int bnum = sc.nextInt(); // B가 가지고 있는 딱지 수	
			for (int i = 0; i < bnum; i++) {
				B[sc.nextInt()]++;
			}
			for (int i = 4; i >= 1; i--) { 
				if (A[i] > B[i]) { // 딱지 비교
					System.out.println("A");
					break;
				} else if (A[i] < B[i]) {
					System.out.println("B");
					break;
				}
				if (i == 1 && A[i] == B[i])
					System.out.println("D");
			}
		}
	}
}