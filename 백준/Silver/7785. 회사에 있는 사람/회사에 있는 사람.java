import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		HashMap<String, String> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if (map.containsKey(name)) {
				map.remove(name);
			} else {
				map.put(name, status);
			}
		}
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());
		
		for (String name : list) {
			bw.write(name + "\n");
		}
		bw.flush();
		bw.close();
	}
}