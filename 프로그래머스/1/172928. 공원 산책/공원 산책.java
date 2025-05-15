import java.util.*;

class Solution {
    static char[][] parkMatrix;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static HashMap<String, Integer> map;
    static int X;
    static int Y;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        parkMatrix = new char[park.length][park[0].length()];
        map = new HashMap<>();
        map.put("N", 0);
        map.put("E", 1);
        map.put("S", 2);
        map.put("W", 3);
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == ('S')) {
                    X = j;
                    Y = i;
                }
                parkMatrix[i][j] = park[i].charAt(j);
            }
        }
        
        getPos(X, Y, 0, routes);
        
        answer[0] = Y;
        answer[1] = X;
        
        return answer;
    }
    
    public void getPos(int currX, int currY, int idx, String[] routes) {
        if (idx == routes.length) return;
        String[] route = routes[idx].split(" ");
        
        boolean chk = true;
        int len = Integer.parseInt(route[1]);
        
        for (int i = 0; i < len; i++) {
            currX += dir[map.get(route[0])][1];
            currY += dir[map.get(route[0])][0];
            
            if (currX < 0 || currX >= parkMatrix[0].length || currY < 0 || currY >= parkMatrix.length
                    || parkMatrix[currY][currX] == 'X') {
                chk = false;
                break;
            }
        }
        
        if (chk) {
            X += dir[map.get(route[0])][1] * len;
            Y += dir[map.get(route[0])][0] * len;
        }
        
        getPos(X, Y, idx + 1, routes);
    }
}