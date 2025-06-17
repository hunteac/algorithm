import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static char[][] star;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] tCnt = new int[6];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) tCnt[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int minTCnt = 0;
        int minPCnt = N / P;
        int pCnt = N % P;
        
        for (int i = 0; i < 6; i++) {
        	if (tCnt[i] % T != 0) minTCnt += tCnt[i] / T + 1;
        	else minTCnt += tCnt[i] / T;
        }
        
        sb.append(minTCnt).append("\n");
        sb.append(minPCnt).append(" ").append(pCnt);
        
        System.out.println(sb);
    }
}