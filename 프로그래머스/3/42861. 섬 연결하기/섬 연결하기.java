import java.util.*;

class Solution {
    public int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        ArrayList<Integer[]> list = new ArrayList<>();
        
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            
            list.add(new Integer[]{a, b, cost});
        }
        
        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            int cost = list.get(i)[2];
            
            if (union(a, b)) {
                answer += cost;
            }
        }
        
        return answer;
    }
    
    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return false;
        
        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        
        return true;
    }
    
    public int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}