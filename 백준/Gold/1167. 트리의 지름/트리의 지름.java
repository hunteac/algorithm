import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        private int num;
        private int len;

        Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    static List<List<Node>> nodeList;
    static boolean[] visited;
    static int V, diameter, tmpNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());

        nodeList = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());

                if (next == -1) break;

                int len = Integer.parseInt(st.nextToken());

                nodeList.get(num).add(new Node(next, len));
            }
        }

        visited = new boolean[V + 1];
        visited[2] = true;
        getDiameter(2, 0);
        
        visited = new boolean[V + 1];
        visited[tmpNode] = true;
        getDiameter(tmpNode, 0);

        System.out.println(diameter);
    }

    public static void getDiameter(int currNum, int currLen) {
    	if (currLen > diameter) {
    		diameter = currLen;
    		tmpNode = currNum;
    	}

        for (int i = 0; i < nodeList.get(currNum).size(); i++) {
            int nextNum = nodeList.get(currNum).get(i).num;   
            int len = nodeList.get(currNum).get(i).len;
            
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                
                getDiameter(nextNum, currLen + len);
            }
        }
    }
}