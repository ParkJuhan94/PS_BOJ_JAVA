package WEEK00.P9205;

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

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK00/P/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Point s = new Point(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

            // 편의점 위치 저장
            for(int i = 0; i < N; i++){

            }

            st = new StringTokenizer(br.readLine());
            Point e = new Point(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

        }




    }

}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}