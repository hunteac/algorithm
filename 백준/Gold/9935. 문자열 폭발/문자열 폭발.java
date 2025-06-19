import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	
        	int len = bomb.length() - 1;
        	char target = bomb.charAt(len);
        	
        	if (c == target && stack.size() >= len) {
        		sb = new StringBuilder();
        		sb.append(c);
        		
        		for (int j = 0; j < len; j++) {
        			sb.append(stack.pop());
        		}
        		
        		sb.reverse();
        		
        		if (!sb.toString().equals(bomb)) {
        			for (int j = 0; j <= len; j++) {
            			stack.push(sb.charAt(j));
            		}
        		}
        	} else {
        		stack.push(c);
        	}
        }
        
        sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        
        if (sb.length() != 0) System.out.println(sb.reverse());
        else System.out.println("FRULA");
    }
}