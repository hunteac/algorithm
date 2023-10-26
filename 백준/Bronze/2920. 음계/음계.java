import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[8];
				
		boolean chk = true;
		
		for (int i = 0; i < 8; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			
			if (nums[i] != i + 1) chk = false;
		}
		
		if (chk) System.out.println("ascending");
		else {
			int num = 1;
			for (int i = 7; i >= 0; i--) {
				if (nums[i] != num) {
					System.out.println("mixed");
					return;
				}
				num++;
			}
			System.out.println("descending");
		}
	}
}