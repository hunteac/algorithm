import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
		String s1 = bf.readLine();
		String s2 = bf.readLine();
        
		StringTokenizer st = new StringTokenizer(s1); 
		StringTokenizer sk = new StringTokenizer(s2);
        
		int ax, ay, az, bx, by, bz, cx, cy, cz;
        
		ax = Integer.parseInt(st.nextToken());
		ay = Integer.parseInt(st.nextToken());
		az = Integer.parseInt(st.nextToken());
		cx = Integer.parseInt(sk.nextToken());
		cy = Integer.parseInt(sk.nextToken());
		cz = Integer.parseInt(sk.nextToken());
		
		bx = cx - az;
		by = cy / ay;
		bz = cz - ax;
		
		System.out.println(bx + " " + by + " " + bz);
	}
}