import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int arr[];
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 숫자카드 오름차순 정렬
		Arrays.sort(arr);
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (binarySearch(num)) bw.write("1" + " ");
			else bw.write("0" + " ");
		}
		bw.flush();
		bw.close();
	}
	// 이진탐색 메소드
	public static boolean binarySearch(int num) {
		int leftIdx = 0;
		int rightIdx = n - 1;
		
		while (leftIdx <= rightIdx) {
			int midIdx = (leftIdx + rightIdx) / 2;
			int mid = arr[midIdx];
			
			if (num < mid) rightIdx = midIdx - 1;
			else if (num > mid) leftIdx = midIdx + 1;
			else return true;
		}
		return false;
	}
}