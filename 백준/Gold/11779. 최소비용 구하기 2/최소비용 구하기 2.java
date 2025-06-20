import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Pos implements Comparable<Pos> {
		int currNum;
		int currCost;
		String route;
		
		Pos(int currNum, int currCost, String route) {
			this.currNum = currNum;
			this.currCost = currCost;
			this.route = route;
		}
		
		@Override
		public int compareTo(Pos p) {
			return this.currCost - p.currCost;
		}
	}
	
	static class Edge {
		int next;
		int cost;
		
		Edge(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Edge>> list = new ArrayList<>(); 
        
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int start = Integer.parseInt(st.nextToken());
        	int target = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new Edge(target, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int len = 0;
        String result = "";
        
        int[] minCosts = new int[n + 1];
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        queue.add(new Pos(start, 0, String.valueOf(start)));
        
        while (!queue.isEmpty()) {
        	Pos p = queue.poll();
        	
        	int currNum = p.currNum;
        	int currCost = p.currCost;
        	String route = p.route;
        	
        	if (currNum == target) {
        		min = currCost;
        		len = route.split(" ").length;
        		result = route;
        		break;
        	}
        	
        	for (Edge e : list.get(currNum)) {
        		int next = e.next;
        		int cost = e.cost;
        		int costSum = currCost + cost;
        		if (costSum < minCosts[next]) {
        			minCosts[next] = costSum;
        			queue.add(new Pos(next, costSum, route + " " + next));
        		}
        	}
        }
        
        sb.append(min).append("\n");
        sb.append(len).append("\n");
        sb.append(result);
        
        System.out.println(sb);
    }
}