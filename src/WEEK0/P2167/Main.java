package WEEK0.P2167;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P2167/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(){

            }

            System.out.println(ans);
        }
    }

}