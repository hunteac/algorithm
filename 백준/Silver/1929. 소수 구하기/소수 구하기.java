import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[end + 1];
        // 에라토스테네스의 체 활용
        for (int i = start; i <= end; i++) {
        	prime[i] = true;
        }
        // 1은 소수가 아니다.
        prime[1] = false;
        // 해당 소수의 배수들 지우기
        for (int i = 2; i <= Math.sqrt(end); i++) {
        	for (int j = i * i; j <= end; j += i) {
        		prime[j] = false;
        	}
        }
        for (int i = start; i <= end; i++) {
        	if (prime[i])
        		sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}