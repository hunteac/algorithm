import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		List<String> list = new LinkedList<>(); // 식을 담는 연결 리스트
		
		for (int i = 0; i < s.length(); i++) {
			String tmp = "";
			
			if (Character.isDigit(s.charAt(i))) { // 숫자 구분
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					tmp += String.valueOf(s.charAt(i));
					i++;
				}
				i--;
				list.add(tmp);
			} else { // 연산자 구분
				list.add(String.valueOf(s.charAt(i)));
			}
		}
		
		boolean chk = false;
		int idx = 0;
		
		// "-" 연산자 뒤의 "+" 연산자 모두 계산
		while (idx < list.size()) {
			if (chk && idx < list.size() - 1) {
				String str = list.get(idx + 1);
				
				if (str.equals("-")) {
					idx += 2;
					continue;
				} else {
					int A = Integer.parseInt(list.remove(idx));
					str = list.remove(idx);
					int B = Integer.parseInt(list.remove(idx));
					
					list.add(idx, String.valueOf(A + B));
					
					continue;
				}
			}
			
			if (list.get(idx).equals("-")) chk = true;
			idx++;
		}
		
		// 나머지 식 계산
		while (list.size() > 1) {
			int A = Integer.parseInt(list.remove(0));
			String str = list.remove(0);
			int B = Integer.parseInt(list.remove(0));
			
			if (str.equals("+")) list.add(0, String.valueOf(A + B));
			else list.add(0, String.valueOf(A - B));
		}
		
		System.out.println(list.get(0));
	}
}