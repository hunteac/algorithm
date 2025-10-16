import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        command = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] channels = new String[N];

        int idx1 = 0;
        int idx2 = 0;

        for (int i = 0; i < N; i++) {
            channels[i] = br.readLine();
            if ("KBS1".equals(channels[i])) {
                idx1 = i;
            } else if ("KBS2".equals(channels[i])) {
                idx2 = i;
            }
        }

        getCommand("3", idx1 - 1);
        if (idx1 > 0) getCommand("1", 1);
        getCommand("4", idx1);
        getCommand("1", idx2);
        getCommand("4", idx2 - 1);

        System.out.println(command);
    }

    public static void getCommand(String com, int idx) {
        for (int i = 0; i < idx; i++) {
            command.append(com);
        }
    }
}