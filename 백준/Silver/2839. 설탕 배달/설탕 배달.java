import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wt = sc.nextInt();
		int twt = 0; // 임시 무게 변수 설정
		int cnt = 0; // 필요한 봉지의 개수
		
		cnt += wt / 5; // 5kg 봉지로 나누어서 개수 세기
		twt = cnt * 5; // 예외 처리를 위한 임시 무게 설정
		while (twt >= 0) {
			if ((wt - twt) % 3 == 0) { // (전체 무게 - 임시 무게)가 3kg 봉지로 나누어 떨어지면
				cnt += (wt - twt) / 3; // 3kg 봉지 개수 더하기
				wt = 0; // 무게 0으로 설정
				break;
			} 
			twt -= 5; // 5kg 봉지 하나씩 줄이면서 확인
			cnt--;
		}
		if (wt == 0) // 무게가 0이면 필요한 봉지 개수 출력
			System.out.println(cnt);
		else if (twt < 0) // 무게가 0보다 작으면 3과 5의 조합으로 무게를 나눌 수 없다
			System.out.println(-1);
		sc.close();
	}
}

// 시도 : 10번 | 오류 : 7번 | 시간초과 : 2번 |
// 처음에는 문제 풀이 방법으로 조건문을 사용해 8(3 + 5)로 나누었을 때 나머지가 0인 경우,
// 5로 나누었을 때 나머지가 0인 경우, 3으로 나누었을 때 나머지가 0인 경우, 
// 그리고 else인 경우로 분류했다. 하지만 311과 같은 케이스는 305 까지는 5kg 봉지를 사용하고
// 나머지 6은 3kg 봉지를 사용하는 방법이 존재한다. 처음 구상했던 식은 이러한 경우를 놓쳤기 때문에 
// 위와 같은 방법으로 새로운 문제 풀이 방법을 고안했다. 처음보다 훨씬 간결한 구성으로 문제를 풀이할 수 있었고,
// 이번 경험을 통해 지금까지 무작정 모든 경우의 수를 생각하는 틀에서 벗어나 더욱 효율적인 방법으로 문제에
// 접근하는 습관을 기를 수 있었다.