import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

// 트리를 구성하는 노드 클래스
class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    
    public Node() {
    }
}

class Solution {
    public static Node[] nodes;
    public static int cnt = 0;
    public static LinkedList<Integer> Alist = new LinkedList<>();
    public static LinkedList<Integer> Blist = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 수 입력
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            // 트리의 정점 개수
            int V = sc.nextInt();
            // 간선의 개수
            int E = sc.nextInt();
            // 공통 조상을 찾는 두 개의 정점 번호
            int A = sc.nextInt();
            int B = sc.nextInt();
            nodes = new Node[V + 1];
            // 트리 정점 노드에 입력 값 넣기
            for (int i = 1; i < nodes.length; i++) {
                nodes[i] = new Node();
                nodes[i].data = i;
            }
            for (int i = 1; i <= E; i++) {
                // 각 노드에 왼쪽 자식, 오른쪽 자식 값 넣기
                int p = sc.nextInt();
                int ch = sc.nextInt();
                if (nodes[p].left == null)
                    nodes[p].left = nodes[ch];
                else
                    nodes[p].right = nodes[ch];
                // 자식 노드에 부모 노드 값 넣기
                nodes[ch].parent = nodes[p];
            }
            // A 노드의 조상들 찾기
            findP1(A);
            // B 노드의 조상들 찾기
            findP2(B);
            // 가장 가까운 공통 조상의 번호 구하기
            int idx = 1;
            int comP = 0;
            // 가장 가까운 공통 조상 찾으면 반복문 탈출
            while (true) {
                if (Alist.contains(Blist.get(idx))) {
                    comP = Blist.get(idx);
                    break;
                }
                idx++;
            }
            System.out.println("#" + test_case + " " + comP + " " + getSize(nodes[comP]));
            // static 필드 초기화
            Alist.clear();
            Blist.clear();
            cnt = 0;
        }
    }
    
    // A 노드 조상들을 찾는 메소드
    public static int findP1(int a) {
        if (nodes[a].parent == null) {
            Alist.add(a);
            return a;
        }
        if (nodes[a].parent != null) {
            Alist.add(a);
            a = findP1(nodes[a].parent.data);
            return a;
        }
        return 0;
    }
    // B 노드 조상들을 찾는 메소드
    public static int findP2(int b) {
        if (nodes[b].parent == null) {
            Blist.add(b);
            return b;
        }
        if (nodes[b].parent != null) {
            Blist.add(b);
            b = findP2(nodes[b].parent.data);
            return b;
        }
        return 0;
    }
    // 공통 조상을 루트로 하는 서브 트리의 크기를 구하는 메소드
    public static int getSize(Node node) {
    	cnt++;
    	if (node.left != null)
    		getSize(node.left);
    	if (node.right != null)
    		getSize(node.right);
    	return cnt;
    }
}