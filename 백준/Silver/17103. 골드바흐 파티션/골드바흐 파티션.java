import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[1000001];
        //에라토스테네스의 체를 사용하여 소수 구하기
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(1000000); i++) {
        	if (!prime[i]) {
        		for (int j = i * i; j <= 1000000; j += i) {
        			prime[j] = true;
        		}
        	}
        }
        // 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	int num = Integer.parseInt(br.readLine());
        	// 골드바흐 파티션의 개수를 구하기 위한 변수 선인 및 초기화
        	int cnt = 0;
        	for (int i = 2; i <= num / 2; i++) {
        		if (!prime[i] && !prime[num - i])
        			cnt++;
        	}
        	System.out.println(cnt);
        }
    }
}