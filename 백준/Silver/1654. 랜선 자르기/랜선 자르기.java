import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long M , max;
	static long[] len;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		len = new long[N];
		max = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			len[i] = a;
			if (a > max) {
				max = a;
			}
		}
		
		binarySearch();
		
	}

	private static void binarySearch() {
		long lo = 0;
		long hi = max+1;
		long mid = 0;
		while (lo < hi) {
			mid = (lo+hi)/2;
//			System.out.println(mid);
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				sum += (len[i]/mid);
			}
			if (sum < M) {
				hi = mid ;
			}else {
				lo = mid + 1;
			}
			
		}
		System.out.println(lo-1);
	}

}
