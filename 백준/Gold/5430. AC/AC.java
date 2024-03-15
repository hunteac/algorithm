import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Outer: for (int t = 0; t < T; t++) {
            String p = br.readLine(); // 함수

            int n = Integer.parseInt(br.readLine()); // 개수

            if (n == 0) {
                if (p.contains("D")) {
                    sb.append("error").append("\n");
                    String nums = br.readLine();
                    continue;
                } else {
                    sb.append("[]").append("\n");
                    String nums = br.readLine();
                    continue;
                }
            }

            String nums = br.readLine(); // 배열
            nums = nums.substring(1, nums.length() - 1); // 괄호 제거
            nums = nums.replace(",", " "); // 쉼표 제거

            int[] arr = new int[n];
            int idx = 0;

            for (int i = 0; i < nums.length(); i++) {
                char curr = nums.charAt(i);
                if (curr != ' ') {
                    int next = i + 1;
                    if (next < nums.length()) {
                        if (nums.charAt(next) == ' ') arr[idx++] = curr - '0';
                        else {
                            while (next < nums.length() && nums.charAt(next) != ' ') {
                                next++;
                            }
                            arr[idx++] = Integer.parseInt(nums.substring(i, next));
                            i = next;
                        }
                    } else {
                        arr[idx++] = curr - '0';
                    }
                }
            }

            boolean chk = false; // false: 원상태, true: 뒤집은 상태
            int leftIdx = 0; // 왼쪽
            int rightIdx = arr.length - 1; // 오른쪽

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') { // 뒤집기
                    chk = !chk;
                } else { // 제거
                    if (leftIdx > rightIdx) {
                        sb.append("error").append("\n");
                        continue Outer;
                    }

                    if (!chk) leftIdx++; // 왼쪽
                    else rightIdx--; // 오른쪽
                }
            }

            StringBuilder answer = new StringBuilder();

            if (!chk) { // 원상태
                for (int i = leftIdx; i <= rightIdx; i++) {
                    answer.append(arr[i]);
                    if (i != rightIdx) answer.append(",");
                }
            } else { // 뒤집은 상태
                for (int i = rightIdx; i >= leftIdx; i--) {
                    answer.append(arr[i]);
                    if (i != leftIdx) answer.append(",");
                }
            }

            sb.append("[" + answer + "]").append("\n");
        }

        System.out.println(sb);
    }
}