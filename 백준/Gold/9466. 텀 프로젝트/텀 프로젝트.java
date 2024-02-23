import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        HashSet<Integer> set = new HashSet<>(); // 팀에 속하는 학생들
        int[] order = new int[100001];

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); // 학생 수
            st = new StringTokenizer(br.readLine());

            boolean[] group = new boolean[n + 1]; // 팀에 속할 수 있는 학생
            boolean[] noGroup = new boolean[n + 1]; // 팀에 속할 수 없는 학생
            int[] nums = new int[n + 1]; // 학생들이 지목한 번호
            int idx = 1;
            int start = 0;
            boolean chk = false; // 팀 구성 가능 여부

            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                if (nums[i] == i) group[i] = true; // 1인 팀
            }

            set.clear();

            for (int i = 1; i <= n; i++) {
                if (group[i] || noGroup[i]) continue; // 팀에 속했거나 속할 수 없으면 continue
                if (group[nums[i]] || noGroup[nums[i]]) {
                    noGroup[i] = true;
                    continue;
                }
                idx = 0;
                start = 0;

                set.clear();
                set.add(i);
                order[idx] = i;

                chk = false;

                Outer: while (!set.isEmpty()) {
                    if (idx >= n) break;
                    int num = nums[order[idx]];
                    idx++;
                    order[idx] = num;

                    if (set.contains(num)) { // 팀 구성 가능
                        chk = true;
                        for (int j = 0; j <= idx; j++) {
                            if (order[j] == num) {
                                start = j;
                                break Outer;
                            }
                        }
                        break;
                    } else if (group[num] || noGroup[num]) { // 팀 구성 불가
                        break;
                    } else {
                        set.add(num);
                    }
                }

                if (chk) { // 팀 구성 가능
                    for (int j = 0; j < start; j++) noGroup[order[j]] = true;
                    for (int j = start; j < idx; j++) group[order[j]] = true;
                } else { // 팀 구성 불가능
                    for (int num : set) noGroup[num] = true;
                }
            }

            int cnt = 0; // 팀에 속하지 못하는 학생 수

            for (int i = 1; i <= n; i++) {
                if (!group[i]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}