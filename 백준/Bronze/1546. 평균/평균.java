import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] n = new double[sc.nextInt()];
		
		for (int i = 0; i < n.length; i++) {
			n[i] = sc.nextDouble();
		}
		
		double max = 0;
		for (int i = 0; i < n.length; i++) {
			max = Math.max(max, n[i]); 
		}
		
		double sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i] / max * 100;	
		}
		
		System.out.println(sum / n.length);
		
	}
}