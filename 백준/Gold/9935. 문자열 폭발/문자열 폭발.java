import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        int bombLen = bomb.length();
        
        for (int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	
        	sb.append(c);
        	
        	if (sb.length() >= bomb.length()) {
        		boolean chk = true;
        		int sbLen = sb.length();
        		
        		for (int j = 0; j < bombLen; j++) {
        			if (sb.charAt(sbLen - bombLen + j) != bomb.charAt(j)) {
        				chk = false;
        				break;
        			}
        		}
        		
        		if (chk) {
        			sb.setLength(sbLen - bombLen);
        		}
        	}
        }
        
        
        if (sb.length() != 0) System.out.println(sb);
        else System.out.println("FRULA");
    }
}