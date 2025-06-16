import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) targets[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(nums);
        
        for (int i = 0; i < M; i++) {
        	int target = targets[i];
        	int left = 0, right = N - 1;
            boolean found = false;
        	
            while (left <= right) {
            	int mid = (left + right) / 2;
            	
            	int num = nums[mid];
            	
            	if (num == target) {
            		found = true;
            		break;
            	} else {
            		if (target > num) {
            			left = mid + 1;
            		} else {
            			right = mid - 1;
            		}
            	}
            }

            sb.append(found ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }
}