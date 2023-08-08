import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wt = sc.nextInt();
		int twt = 0;
		int cnt = 0; // 필요한 봉지의 개수 세기
		
		cnt += wt / 5;
		twt = cnt * 5;
		while (twt >= 0) {
			if ((wt - twt) % 3 == 0) {
				cnt += (wt - twt) / 3;
				wt = 0;
				break;
			} 
			twt -= 5;
			cnt--;
		}
		if (wt == 0) // 무게가 0이면 필요한 봉지 개수 출력
			System.out.println(cnt);
		else if (twt < 0)
			System.out.println(-1);
		sc.close();
	}
}