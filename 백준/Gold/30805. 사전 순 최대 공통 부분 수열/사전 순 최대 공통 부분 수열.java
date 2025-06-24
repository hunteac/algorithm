import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, Integer> idxMap;
	static ArrayList<Integer> result;
	static int[] A, B;
	static int N, M, max;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
        
        idxMap = new HashMap<>();
        result = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
        	int aNum = A[i];
        	for (int j = 0; j < M; j++) {
        		int bNum = B[j];
        		boolean flag = false;
        		
        		if (aNum == bNum) {
        			flag = getSequence(aNum, j);
        		}
        		
        		if (flag) break;
        	}
        }
        
        sb.append(result.size()).append("\n");
        for (Integer num : result) sb.append(num).append(" ");

        System.out.println(sb);
    }
    
    public static boolean getSequence(int num, int idx) {
    	if (num > max) { // 초기화
			max = num;
			result.removeAll(result);
			idxMap.clear();
		}
		
		int last = 0;
		int lastIdx = 0;
		
		for (int k = 0; k < result.size(); k++) {
			if (result.get(k) < num) break;
			last = result.get(k);
			lastIdx = k + 1;
		}
		
		if (idxMap.containsKey(last) && idx <= idxMap.get(last)) {
			return false;
		} else {
			while (lastIdx < result.size()) {
				result.remove(lastIdx);
			}
			
			result.add(num);
			idxMap.put(num, idx);
		}
		
		return true;
    }
}