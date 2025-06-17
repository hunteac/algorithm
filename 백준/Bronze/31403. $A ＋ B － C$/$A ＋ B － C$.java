import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static char[][] star;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        sb.append(A + B - C).append("\n");
        
        String num = String.valueOf(A) + String.valueOf(B);
        
        sb.append(Integer.parseInt(num) - C);
        
        System.out.println(sb);
    }
}