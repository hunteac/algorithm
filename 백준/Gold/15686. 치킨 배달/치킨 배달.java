import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer[]> house; // 집 위치 리스트
	static List<Integer[]> store; // 치킨집 위치 리스트
	static boolean[] visited; // 방문 체크
	static int[] sel; // 조합 선택 배열
	static int N; // 도시 크기
	static int M; // 선택할 치킨집 수
	static int min; // 최소 치킨 거리
	
	// 조합 알고리즘
	static void comb(int idx, int idx1) {
		if (idx == M) {
			int[] len = new int[house.size()]; // 각 집마다 치킨집과의 최소 거리
			Arrays.fill(len, Integer.MAX_VALUE);
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < house.size(); j++) {
					int x = Math.abs(store.get(sel[i])[0] - house.get(j)[0]); // 거리 구하기
	        		int y = Math.abs(store.get(sel[i])[1] - house.get(j)[1]); // 거리 구하기
	        		
	        		len[j] = Math.min(len[j], x + y);
		        }
			}
			
			int comp = 0;
			for (int i = 0; i < len.length; i++) {
				comp += len[i];
			}
			
			min = Math.min(min, comp); // 최솟값 갱신
			return; // 종료
		}
		
		if (idx1 == store.size()) return;
		
		sel[idx] = idx1;
		comb(idx + 1, idx1 + 1);
		comb(idx, idx1 + 1);
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        house = new ArrayList<>();
        store = new ArrayList<>();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        
        int[][] city = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		city[i][j] = Integer.parseInt(st.nextToken());
        		if (city[i][j] == 1) { // 집 위치 리스트에 담기
        			house.add(new Integer[] {i, j});
        		} else if (city[i][j] == 2) { // 치킨집 위치 리스트에 담기
        			store.add(new Integer[] {i, j});
        		}
        	}
        }
        
        visited = new boolean[store.size()];
        sel = new int[M];
        
        comb(0, 0); // 조합 알고리즘
        
        System.out.println(min);
    }
}