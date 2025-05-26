import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class Main {
    public static class Student implements Comparable<Student> {
        private String name;
        private int kor;
        private int eng;
        private int math;
        
        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        
        public String getName() {
            return this.name;
        }
        
        public int getKor() {
            return this.kor;
        }
        
        public int getEng() {
            return this.eng;
        }
        
        public int getMath() {
            return this.math;
        }
        
        @Override
        public int compareTo(Student s) {
            if (this.kor != s.kor) { // 내림차순
                return s.kor - this.kor;
            }
            
            if (this.eng != s.eng) { // 오름차순
                return this.eng - s.eng;
            }
            
            if (this.math != s.math) { // 내림차순
                return s.math - this.math;
            }
            
            return this.name.compareTo(s.name); // 오름차순
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        ArrayList<Student> list = new ArrayList<>();
            
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken()); // 국어
            int eng = Integer.parseInt(st.nextToken()); // 영어
            int math = Integer.parseInt(st.nextToken()); // 수학

            list.add(new Student(name, kor, eng, math));
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getName()).append("\n");
        }

        System.out.println(sb);
    }
}