import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr, tmp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[N + M];
        tmp = new int[N + M];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = N; i < N + M; i++) arr[i] = Integer.parseInt(st.nextToken());

        mergeSort(0, N + M - 1);
        
        for (int i = 0; i < arr.length; i++) sb.append(arr[i]).append(" ");
        
        System.out.println(sb);
    }
    
    public static void mergeSort(int left, int right) {
    	if (left >= right) return;
    	
    	int mid = (left + right) / 2;
    	mergeSort(left, mid);
    	mergeSort(mid + 1, right);
    	merge(left, mid, right);
    }
    
    public static void merge(int left, int mid, int right) {
    	int l = left;
    	int r = mid + 1;
    	int k = l;
    	
    	while (l <= mid && r <= right) {
    		if (arr[l] <= arr[r]) tmp[k++] = arr[l++];
    		else tmp[k++] = arr[r++];
    	}
    	
    	if (l > mid) {
    		for (int i = r; i <= right; i++) {
    			tmp[k++] = arr[i];
    		}
    	} else {
    		for (int i = l; i <= mid; i++) {
    			tmp[k++] = arr[i];
    		}
    	}
    	
    	for (int i = left; i <= right; i++) {
    		arr[i] = tmp[i];
    	}
    }
}