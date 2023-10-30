import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String[] arr = str.split("");

		Stack<String> sta = new Stack<>();

		int num = 1;	
		int res = 0;
		boolean open = false;
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			String tem = arr[i];
			if (tem.equals("(")) {
				sta.add("(");
				open = true;
				num *= 2;
			}else if (tem.equals("[")) {
				sta.add("[");
				open = true;
				num *= 3;
			}else if (tem.equals(")")) {
				if (sta.isEmpty()) {
					flag = false;
					break;
				}
				tem = sta.pop();
				if (!tem.equals("(")) {
					flag = false;
					break;
				}
				if (open) {
					res += num;
					num /= 2;
					open = false;
				}else {
					num /= 2;
				}
				
			}else if (tem.equals("]")) {
				if (sta.isEmpty()) {
					flag = false;
					break;
				}
				tem = sta.pop();
				if (!tem.equals("[")) {
					flag = false;
					break;
				}
				if (open) {
					res += num;
					num /= 3;
					open = false;
				}else {
					num /= 3;
				}
			}
		}
		
		if (!sta.isEmpty()) {
			flag = false;
		}
		
		if (flag) {
			System.out.println(res);
		}else {
			System.out.println(0);
		}
	}
}
