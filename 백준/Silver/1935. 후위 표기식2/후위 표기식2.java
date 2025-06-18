import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        HashMap<Integer, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
        	double num = Double.parseDouble(br.readLine());
        	map.put(65 + i, num);
        }
        
        for (int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	
        	if (c >= 'A' && c <= 'Z') {
        		stack.push(map.get((int) c));
        	} else {
        		double A = stack.pop();
        		double B = stack.pop();
        		double result = operate(A, B, c);
        		stack.push(result);
        	}
        }
        
        System.out.println(String.format("%.2f", stack.pop()));
    }
    
    public static double operate(double A, double B, char op) {
    	if (op == '+') return B + A;
    	if (op == '-') return B - A;
    	if (op == '*') return B * A;
    	if (op == '/') return B / A;
    	return 0;
    }
}