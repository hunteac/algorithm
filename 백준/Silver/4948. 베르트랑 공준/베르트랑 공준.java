import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
        	// 시작 숫자
        	int start = Integer.parseInt(br.readLine());
            // 마지막 숫자 == 시작 숫자 * 2
        	int end = start * 2;
            // 소수의 개수를 구하기 위한 변수 선언 및 초기화
        	int cnt = 0;
            // 0 입력시 반복문 종료
        	if (start == 0)
            	break;
            // 에라토스테네스의 체 활용
            boolean[] prime = new boolean[end + 1];
            for (int i = start + 1; i <= end; i++) {
            	prime[i] = true;
            }
            // 1은 소수가 아니다.
            prime[1] = false;
            for (int i = 2; i <= Math.sqrt(end); i++) {
            	// i의 배수들 지우기
            	for (int j = i * i; j <= end; j += i) {
            		if (j % i == 0)
            			prime[j] = false;
            	}
            }
            for (int i = start + 1; i <= end; i++) {
            	if (prime[i])
            		cnt++;
            }
            System.out.println(cnt);
        }
    }
}