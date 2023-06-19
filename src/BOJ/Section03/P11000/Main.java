package BOJ.Section03.P11000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section03/P11000/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Lesson[] lessons = new Lesson[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            long s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());

            lessons[i] = new Lesson(s, e);
        }







        System.out.print(sb);
        //System.out.println(ans);
    }

    static class Lesson implements Comparable<Lesson>{
        long start;
        long end;

        public Lesson(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lesson o) {
            return 0;
        }
    }
}