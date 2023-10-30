import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int[] partPeople;
	static boolean[][] part;
	static boolean[][] tfPart;
	static ArrayList<Integer> AList;
	static ArrayList<Integer> BList;
	static int verTaxNum , num , min , temp;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		num = Integer.parseInt(br.readLine());
		
		verTaxNum = 0;
		min = Integer.MAX_VALUE;
		
		partPeople = new int[num+1];
		
		AList = new ArrayList<Integer>();
		AList.add(1);						// AList BList 중복을 방지하기위해 고정
		BList = new ArrayList<Integer>();
		
		
		part = new boolean[num+1][num+1];
		tfPart = new boolean[num+1][num+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= num; i++) {
			partPeople[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 1; i <= num; i++) {
			st = new StringTokenizer(br.readLine());
			int nn = Integer.parseInt(st.nextToken());
			verTaxNum += nn;
			for (int j = 0; j < nn; j++) {
				int nnn = Integer.parseInt(st.nextToken());
				part[i][nnn] = true;
				part[nnn][i] = true;
			}
		}
		

		
		
		verTaxNum /= 2; // 총 간선의 수
		
		set(2);
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	private static void set(int time) { // 간선 자르기
		if ( time == num + 1 ) {
//			System.out.println(" AList : " + AList.toString());
//			System.out.println(" BList : " + BList.toString());
			if (check(AList) && check(BList)) {
				res();
			}
//			if (min == 1) {
//				System.out.println("1111111111111111111111");
//			}
			return;
		}
		
		AList.add(time);
		set(time+1);
		AList.remove(AList.size()-1);
		BList.add(time);
		set(time+1);
		BList.remove(BList.size()-1);
				
	}


	private static boolean check(ArrayList<Integer> arrList) {      // 각 마을이 연결 되어져 있는 지 확인
		
		int size = arrList.size();
		
		if (size == 0) {
			return false;
		}
//		
		if (size == 1) {
			return true;
		}
//		for (int i = 0; i < size-1; i++) {
//			int a = arrList.get(i);
//			for (int j = i+1; j < size; j++) {
////				System.out.println("i : " + i + " j : " + j);
//				if(part[a][arrList.get(j)]) {
//					if (!ta[a]) {
//						ta[a] = true;
//						temp++;
//					}
//					if (!ta[arrList.get(j)]) {
//						ta[arrList.get(j)] = true;
//						temp++;
//					}
//				}
//			}
//		}
		boolean[] ta = new boolean[num+1]; 
		temp = 0;
		
		Queue<Integer> que = new LinkedList<Integer>();
		
//		que.add(arrList.get(0));
		que.add(0);
		
		while (!que.isEmpty()) {
			int a = que.poll();
			int b = arrList.get(a);
			
			for (int i = 0  ; i < size; i++) {
				if (part[b][arrList.get(i)]) {
					if (!ta[b]) {
						que.add(i);
						ta[b] = true;
						temp++;
					}
					if (!ta[arrList.get(i)]) {
						que.add(i);
						ta[arrList.get(i)] = true;
						temp++;
					}
				}
			}
		}
		
		if (size == temp) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	private static void res() {				// 값 계산
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < AList.size(); i++) {
			a += partPeople[AList.get(i)];
		}
		for (int i = 0; i < BList.size(); i++) {
			b += partPeople[BList.get(i)];
		}
		
		int r = Math.abs(a-b);
		min = Math.min(r, min);
		
	}
	
	
}
