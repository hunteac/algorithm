import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());

        int idx1 = 0;
        int idx2 = 0;
        
        for (int i = 0; i < N + M; i++) {
        	if (idx1 < N && idx2 < M) {
        		int num1 = arr1[idx1];
            	int num2 = arr2[idx2];
        		
        		if (num1 <= num2) {
        			sb.append(arr1[idx1++]).append(" ");
        		} else {
        			sb.append(arr2[idx2++]).append(" ");
        		}
        	} else if (idx2 < M) {
        		sb.append(arr2[idx2++]).append(" ");
        	} else {
        		sb.append(arr1[idx1++]).append(" ");
        	}
        }
        
        System.out.println(sb);
    }
}