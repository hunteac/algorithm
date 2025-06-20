import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static StringBuilder sb;
	static int[][] tree;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer> preOrder = new ArrayList<>();
        
        while (true) {
        	String node = br.readLine();
        	if (node == null) break;
        	
        	preOrder.add(Integer.parseInt(node));
        }
        
        sb = new StringBuilder();
        tree = new int[1000000][2];
        
        for (int i = 1; i < preOrder.size(); i++) {
        	int node = preOrder.get(i);
        	int before = preOrder.get(i - 1);
        	
        	if (node < before) { // 왼쪽 노드
        		tree[before][0] = node; 
        	} else { // 오른쪽 노드
        		int idx = i - 1;
        		int max = 0;
        		
        		while (idx >= 0) {
        			int comp = preOrder.get(idx);
        			
        			if (node < comp) break;
        			
        			max = Math.max(max, comp);
        			idx--;
        		}
        		
        		tree[max][1] = node;
        	}
        }
        
        getPostOrder(preOrder.get(0));

        System.out.println(sb);
    }
    
    public static void getPostOrder(int root) {
    	if (tree[root][0] != 0) getPostOrder(tree[root][0]);
    	if (tree[root][1] != 0) getPostOrder(tree[root][1]);

    	sb.append(root).append("\n");
    }
}