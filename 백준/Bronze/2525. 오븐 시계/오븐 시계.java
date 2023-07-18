import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		if (t < 60 && m + t < 60) {
			System.out.printf("%d %d", h, m + t);
		} else if (t < 60 && m + t >= 60) {
			h = (h + 1) % 24;
			m = m + t - 60;
			System.out.printf("%d %d", h, m);
		} else if (t == 60) {
			h = (h + 1) % 24;
			System.out.printf("%d %d", h, m);
		} else if (t > 60 && m + (t % 60) < 60) {
			m = m + (t % 60);
			h = h + (t / 60);
			h = h % 24;
			System.out.printf("%d %d", h, m);
		} else if (t > 60 && m + (t % 60) >= 60) {
			m = m + (t % 60) - 60;
			h = h + (t / 60);
			h = (h + 1) % 24;
			System.out.printf("%d %d", h, m);
		}
		
	}
}