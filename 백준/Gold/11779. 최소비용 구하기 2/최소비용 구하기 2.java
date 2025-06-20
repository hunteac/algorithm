import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int next;
		int cost;
		
		Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
	}
	
	static int n, m;
	static int[] d, preCity;
	static int start, end;
	static ArrayList<ArrayList<Node>> list;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        preCity = new int[n + 1];
        
        Arrays.fill(d, Integer.MAX_VALUE);
        
        list = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int start = Integer.parseInt(st.nextToken());
        	int target = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new Node(target, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        
        int curr = end;
        int len = 1;
        String route = "";
        Stack<Integer> stack = new Stack<>();
        
        while (preCity[curr] != 0) {
        	int pre = preCity[curr];
        	stack.push(curr);
        	curr = pre;
        	len++;
        }
        
        stack.push(start);
        
        while (!stack.isEmpty()) {
        	route += stack.pop() + " ";
        }
        
        sb.append(d[end]).append("\n");
        sb.append(len).append("\n");
        sb.append(route);
        
        System.out.println(sb);
    }
    
    public static void dijkstra(int start) {
    	PriorityQueue<Node> queue = new PriorityQueue<>();
    	queue.add(new Node(start, 0));
    	d[start] = 0;
    	
    	while (!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		int curr = node.next;
    		
    		if (node.cost > d[curr]) continue;
    		
    		for (Node next : list.get(curr)) {
    			if (d[next.next] > d[curr] + next.cost) {
    				d[next.next] = d[curr] + next.cost;
    				preCity[next.next] = curr;
    				queue.add(new Node(next.next, d[next.next]));
    			}
    		}
    	}
    	
    }
}