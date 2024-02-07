import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			int time = Integer.parseInt(br.readLine());
            
			for(int j = 0; j < time; j++) {
				list.add(i);
			}
		}
		
		for(int i = 0; i < Q; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(list.get(num)).append("\n");
		}
        
		System.out.println(sb);
	}
}