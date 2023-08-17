import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] age = new int[n];
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	age[i] = Integer.parseInt(st.nextToken());
        	name[i] = st.nextToken();
        }
        for (int i = 0; i < n - 1; i++) {
        	if (age[i] > age[i + 1]) {
        		int idx = i;
        		// 가입한 순서대로 입력됐기 때문에 회원들의 나이순으로만 정렬
        		while (idx >= 0 && age[idx] > age[idx + 1]) {
        			int temp1 = age[idx];
        			age[idx] = age[idx + 1];
        			age[idx + 1] = temp1;
        			String temp2 = name[idx];
        			name[idx] = name[idx + 1];
        			name[idx + 1] = temp2;
        			idx--;
        		}
        	}
        }
        for (int i = 0; i < n; i++) {
        	sb.append(age[i]).append(" ");
        	sb.append(name[i]).append("\n");
        }
        System.out.println(sb);
    }
}