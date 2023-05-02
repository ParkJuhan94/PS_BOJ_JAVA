package WEEK0.P2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] ch;
    static int[][] dist;
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, -1, 0, 1};
    static int min;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P2178/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        ch = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(Character.toString(input.charAt(j)));
            }
        }

        int ans = 0;
//        ch[0][0] = true;
//        min = Integer.MAX_VALUE;
//        search(0, 0, 1);

        dist[0][0] = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while(!q.isEmpty()){
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(0 <= nr && nr < N && 0 <= nc && nc < M &&
                        map[nr][nc] == 1 && dist[nr][nc] == 0){
                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }

//    static void search(int r, int c, int cnt){
//        if(r == N - 1 && c == M - 1){
//            if(min > cnt){
//                min = cnt;
//            }
//            return;
//        }
//
//        for(int i = 0; i < 4; i++){
//            int nr = r + dr[i];
//            int nc = c + dc[i];
//
//            if(0 <= nr && nr < N && 0 <= nc && nc < M &&
//                    !ch[nr][nc] && map[nr][nc] == 1){
//                ch[nr][nc] = true;
//                search(nr, nc, cnt + 1);
//                ch[nr][nc] = false;
//            }
//        }
//    }

}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}