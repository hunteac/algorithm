import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 창문과 사람 수 변수
        int num = Integer.parseInt(br.readLine());
        // 열려 있는 창문 개수 변수
        int cnt = 0;
        // 약수의 개수가 홀수인 수만 최종적으로 열려 있다. (제곱 수)
        for (int i = 1; i <= num; i++) {
        	if (i * i <= num)
        		cnt++;
        	else 
        		break;
        }
        System.out.println(cnt);
    }
}