import java.util.*;

class Solution {
    static int len;
    static boolean chk;
    
    static void chkRoot(String tree, int root, int layer) {
        if (root < 0 || root >= len || layer <= 0) {
            return;
        }
        
        if (tree.charAt(root) == '0' && (tree.charAt(root - layer) == '1' || tree.charAt(root + layer) == '1')) {
            chk = false;
            return;
        }
    
        chkRoot(tree, root - layer, layer / 2);
        chkRoot(tree, root + layer, layer / 2);
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        Outer: for (int idx = 0; idx < numbers.length; idx++) {
            String tree = Long.toBinaryString(numbers[idx]); // 이진수 변환
            chk = true;
            
            int nums = 0;
            int layer = 0;
            
            while (true) {
                nums += Math.pow(2, layer);
                
                if (tree.length() < nums) {
                    int tmp = tree.length();
                    for (int i = 0; i < nums - tmp; i++) {
                        tree = "0" + tree;
                    }
                    break;
                } else if (tree.length() == nums) {
                    break;
                }
                
                layer++;
            }
            
            len = tree.length();
            layer = (int) Math.pow(2, layer - 1);
            
            chkRoot(tree, tree.length() / 2, layer);
             
            if (chk) answer[idx] = 1; // 이진 트리 표현 가능
            else answer[idx] = 0; // 이진 트리 표현 불가능
        }
        
        return answer;
    }
}