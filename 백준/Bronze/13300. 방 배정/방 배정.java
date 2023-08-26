import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 참가 학생 수
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원
		int[] wroom = new int[7]; // 학년별 여학생 방을 의미하는 배열 선언
		int[] mroom = new int[7]; // 학년별 남학생 방을 의미하는 배열 선언
		int cnt = 0; // 필요한 방 수
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt(); // 성별
			int Y = sc.nextInt(); // 학년
			if (S == 0) { 
				if (wroom[Y] == 0)
					cnt++;
				wroom[Y]++;
			}
			else {
				if (mroom[Y] == 0)
					cnt++;
				mroom[Y]++;
			}
			if (wroom[Y] == K) { // 방이 가득차면
				wroom[Y] = 0; // 새로운 방 구하기
			}
			if (mroom[Y] == K) { // 방이 가득차면
				mroom[Y] = 0; // 새로운 방 구하기
			}
		}
		System.out.println(cnt);
	}
}
