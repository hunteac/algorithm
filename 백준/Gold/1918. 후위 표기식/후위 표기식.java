import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static Stack<Character> stack; 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        
        stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	
        	if (Character.isLetter(c)) {
        		sb.append(c);
        	} else if (c == '(') {
        		stack.push(c);
        	} else if (c == ')') {
        		while (!stack.isEmpty() && stack.peek() != '(') {
        			sb.append(stack.pop());
        		}

        		stack.pop();
            } else {
            	while (!stack.isEmpty() && (precedence(stack.peek()) >= precedence(c))) {
            		if (stack.peek() == '(') break;
            		sb.append(stack.pop());
            	}
            	
            	stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }
    
    public static int precedence(char c) {
    	if (c == '+' || c == '-') return 1;
    	if (c == '*' || c == '/') return 2;
    	return 0;
    }
}