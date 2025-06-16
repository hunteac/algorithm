import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double Ax = Integer.parseInt(st.nextToken());
        double Ay = Integer.parseInt(st.nextToken());
        double Bx = Integer.parseInt(st.nextToken());
        double By = Integer.parseInt(st.nextToken());
        double Cx = Integer.parseInt(st.nextToken());
        double Cy = Integer.parseInt(st.nextToken());
        double Dx = Integer.parseInt(st.nextToken());
        double Dy = Integer.parseInt(st.nextToken());
        
        int interval = 1000000;
        
        double aDx = (Bx - Ax) / interval;
        double aDy = (By - Ay) / interval;
        double cDx = (Dx - Cx) / interval;
        double cDy = (Dy - Cy) / interval;
        
        int left = 0;
        int right = interval;
        
        while (right - left >= 3) {
        	int p = (2 * left + right) / 3;
        	int q = (left + 2 * right) / 3;
        	
        	double pVal = getDistance(Ax + aDx * p, Ay + aDy * p, Cx + cDx * p, Cy + cDy * p);
        	double qVal = getDistance(Ax + aDx * q, Ay + aDy * q, Cx + cDx * q, Cy + cDy * q);
        	
        	if (pVal < qVal) {
        		right = q - 1;
        	} else {
        		left = p + 1;
        	}
        }

        double min = getDistance(Ax + aDx * right, Ay + aDy * right, Cx + cDx * right, Cy + cDy * right);
        
        for (int i = left; i < right; i++) {
        	double tmp = getDistance(Ax + aDx * i, Ay + aDy * i, Cx + cDx * i, Cy + cDy * i);

        	min = Math.min(min, tmp);
        }
        
        System.out.println(min);
    }
    
    public static double getDistance(double x1, double y1, double x2, double y2) {
    	double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    	
    	return dist;
    }
}