import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] arr = new int[6];
    	int x = 0;
    	int y = 0;
    	
    	for (int i = 0; i < 6; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	int n1 = arr[0];
    	int n2 = arr[3];
   		int n3 = arr[1];
   		int n4 = arr[4];
   		for (int i = 0; i < 3; i++) {
   		if (arr[0] != 0 && arr[3] != 0) {
    			arr[i] = arr[i] * n2;
    			arr[i + 3] = arr[i + 3] * n1;
    		} else if (arr[1] != 0 && arr[4] != 0) {
    			arr[i] = arr[i] * n4;
    			arr[i + 3] = arr[i + 3] * n3;
    		}
    	}
    	
    	if (arr[0] == arr[3]) {
    		y = (arr[2] - arr[5]) / (arr[1] - arr[4]);
    		x = (arr[2] - (arr[1] * y)) / arr[0];
    	} else if (arr[1] == arr[4]) {
    		x = (arr[2] - arr[5]) / (arr[0] - arr[3]);
    		y = (arr[2] - (arr[0] * x)) / arr[1];
    	}
    	
    	if (arr[0] == 0) {
    		y = arr[2] / arr[1];
    		x = (arr[5] - (arr[4] * y)) / arr[3];
    	} else if (arr[1] == 0) {
    		x = arr[2] / arr[0];
    		y = (arr[5] - (arr[3] * x)) / arr[4];
    	} else if (arr[3] == 0) {
    		y = arr[5] / arr[4];
    		x = (arr[2] - (arr[1] * y)) / arr[0];
    	} else if (arr[4] == 0) {
    		x = arr[5] / arr[3];
    		y = (arr[2] - (arr[0] * x)) / arr[1];
    	}
    	
    	System.out.println(x + " " + y);
    	sc.close();
    	
    }
}