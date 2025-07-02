import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Light implements Comparable<Light> {
        int pos;
        int intensity;

        Light(int pos, int intensity) {
            this.pos = pos;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Light light) {
            return this.intensity == light.intensity ? this.pos - light.pos : light.intensity - this.intensity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] intensities = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) intensities[i] = Integer.parseInt(st.nextToken());

        PriorityQueue<Light> lights = new PriorityQueue<>();

        for (int i = 0; i < 2 * M - 1; i++) {
            lights.add(new Light(i, intensities[i]));
        }

        for (int i = M - 1; i < N - M + 1; i++) {
            int next = i + M;

            Light light = getMaxLight(lights, i, M - 1);

            if (i != N - M) lights.add(new Light(next, intensities[next]));

            sb.append(light.intensity).append(" ");
        }

        System.out.println(sb);
    }

    public static Light getMaxLight(PriorityQueue<Light> lights, int pos, int len) {
        Light light = null;

        while (!lights.isEmpty()) {
            Light curr = lights.peek();

            if (curr.pos < pos - len) {
                lights.poll();
            } else {
                light = curr;
                break;
            }
        }

        return light;
    }
}