import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] A = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE; // 최소 횟수
        int cnt = 0; // 횟수
        int rLen = 3; // 행 개수
        int cLen = 3; // 열 개수

        while (rLen <= 100 || cLen <= 100) {
            if (r - 1 < A.length && c - 1 < A[0].length && A[r - 1][c - 1] == k) {
                min = cnt;
                break;
            }
            if (cnt >= 100) break; // 100초가 지나도 불가능

            LinkedList<Integer>[] lists = new LinkedList[Math.max(rLen, cLen)];

            for (int i = 0; i < lists.length; i++) lists[i] = new LinkedList<>();

            boolean chk = false; // 연산 종류 체크
            int maxRLen = 0;
            int maxCLen = 0;

            if (rLen >= cLen) { // R 연산
                for (int i = 0; i < rLen; i++) {
                    PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
                        @Override
                        public int compare(Integer[] o1, Integer[] o2) {
                            if (o1[1] == o2[1]) return o1[0] - o2[0];
                            return o1[1] - o2[1];
                        }
                    });
                    HashMap<Integer, Integer> map = new HashMap<>();

                    for (int j = 0; j < cLen; j++) {
                        if (A[i][j] == 0) continue;
                        map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
                    }

                    for (int num : map.keySet()) pq.add(new Integer[]{num, map.get(num)});

                    int len = 0;

                    while (!pq.isEmpty()) {
                        if (len == 100) break; // 최대 100개
                        Integer[] nums = pq.poll();

                        lists[i].add(nums[0]);
                        lists[i].add(nums[1]);

                        len += 2;
                    }

                    maxRLen = rLen;
                    maxCLen = Math.max(maxCLen, len);
                }
            } else { // C 연산
                chk = true;
                for (int i = 0; i < cLen; i++) {
                    PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
                        @Override
                        public int compare(Integer[] o1, Integer[] o2) {
                            if (o1[1] == o2[1]) return o1[0] - o2[0];
                            return o1[1] - o2[1];
                        }
                    });
                    HashMap<Integer, Integer> map = new HashMap<>();

                    for (int j = 0; j < rLen; j++) {
                        if (A[j][i] == 0) continue;
                        map.put(A[j][i], map.getOrDefault(A[j][i], 0) + 1);
                    }

                    for (int num : map.keySet()) pq.add(new Integer[]{num, map.get(num)});

                    int len = 0;

                    while (!pq.isEmpty()) {
                        if (len == 100) break; // 최대 100개
                        Integer[] nums = pq.poll();

                        lists[i].add(nums[0]);
                        lists[i].add(nums[1]);

                        len += 2;
                    }

                    maxRLen = Math.max(maxRLen, len);
                    maxCLen = cLen;
                }
            }

            rLen = maxRLen; // 길이 갱신
            cLen = maxCLen;

//            System.out.println("rLen : " + rLen + " cLen : " + cLen);

            A = new int[rLen][cLen];

            if (!chk) { // R 연산
                for (int i = 0; i < lists.length; i++) {
                    for (int j = 0; j < lists[i].size(); j++) {
                        A[i][j] = lists[i].get(j);
                    }
                }
            } else { // C 연산
                for (int i = 0; i < lists.length; i++) {
                    for (int j = 0; j < lists[i].size(); j++) {
                        A[j][i] = lists[i].get(j);
                    }
                }
            }

            cnt++;
        }

        if (min != Integer.MAX_VALUE) System.out.println(min); // 가능
        else System.out.println(-1); // 불가능
    }
}