import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int to;
		int dist;
		
		Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.dist - node.dist;
		}
	}
	
	static ArrayList<ArrayList<Node>> graph;
	static boolean[][] chk;
	static int[][] dists;
	static int N, E, v1, v2;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        chk = new boolean[N + 1][N + 1];
        dists = new int[N + 1][N + 1];
        
        for (int i = 0; i <= N; i++) {
        	graph.add(new ArrayList<>());
        	Arrays.fill(dists[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	graph.get(a).add(new Node(b, c));
        	graph.get(b).add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        dijkstra(1);
        if (v1 != 1) dijkstra(v1);
        dijkstra(v2);

        int min = Integer.MAX_VALUE;
        
        if (chk[1][v1] && chk[v1][v2] && chk[v2][N]) {
        	min = dists[1][v1] + dists[v1][v2] + dists[v2][N];
        }
        
        if (chk[1][v2] && chk[v2][v1] && chk[v1][N]) {
        	min = Math.min(min, dists[1][v2] + dists[v2][v1] + dists[v1][N]);
        }
        
        if (min != Integer.MAX_VALUE) System.out.println(min);
        else System.out.println(-1);
    }
    
    public static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start, 0));
    	
    	dists[start][start] = 0;
    	chk[start][start] = true;
    	
    	while (!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		int curr = node.to;
    		int dist = node.dist;

    		if (dist > dists[start][curr]) continue;
    		
    		for (Node next : graph.get(curr)) {
    			int to = next.to;
    			int distSum = dist + next.dist;
    			if (dists[start][to] > distSum) {
    				dists[start][to] = distSum;
    				dists[to][start] = distSum;
    				chk[to][start] = true;
    				chk[start][to] = true;
    				pq.add(new Node(to, dists[start][to]));
    			}
    		}
    	}
    }
}