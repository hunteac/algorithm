import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        StringBuffer sb = new StringBuffer(T);
        String reverseT = sb.reverse().toString();

        boolean chk = false;

        Queue<String> queue = new LinkedList<>();
        queue.add(S);

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str.equals(T)) {
                chk = true;
                break;
            }

            sb = new StringBuffer(str);
            String reverse = sb.reverse().toString();

            if (T.contains(str + "A") || reverseT.contains(str + "A")) queue.add(str + "A");
            if (T.contains(reverse + "B") || reverseT.contains(reverse + "B")) queue.add(reverse + "B");
        }

        if (chk) System.out.println(1);
        else System.out.println(0);
    }
}