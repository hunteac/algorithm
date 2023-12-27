import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) { // 입력없으면 종료

			int sh = sc.nextInt();
			int sm = sc.nextInt();
			int ss = sc.nextInt();
			int eh = sc.nextInt();
			int em = sc.nextInt();
			int es = sc.nextInt();

			// 출근 시간과 퇴근시간을 각각 초로 변환한 후 뺀다.
			// 그 초를 시간으로 바꾸는 작업을 할 것이다.

			int totalSecondS = sh * 3600 + sm * 60 + ss; // 출근시간
			int totalSecondE = eh * 3600 + em * 60 + es; // 퇴근시간

			int totalSecond = totalSecondE - totalSecondS;
//		System.out.println(totalSecond); //총 초

			// 총 초를 시 분 초로 바꿔주기
			int h = totalSecond / 3600;
			int m = (totalSecond - h * 3600) / 60;
			int s = (totalSecond - h * 3600) % 60;
			System.out.println(h + " " + m + " " + s);
		}
		sc.close();
	}
}