import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 찾고자 하는 영화 순서
		int num = 666;

		while (n > 0) {
			String str = String.valueOf(num); // 숫자를 문자열로 변환하여 666 포함 여부 확인
			if (str.contains("666")) { // 만약 숫자에 "666"이 포함되어 있다면
				n--; // 영화 수 감소
				if (n == 0) // n이 0이 되면 원하는 제목의 영화이므로
					System.out.println(str); // 영화 제목의 수 출력
			}
			num++;
		}
		sc.close();
	}
}