package WEEK0.P2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dist;
    static boolean[][] ch;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P2468/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;
        int sum = 0;

        for(int limit = 1; limit <= 100; limit++){
            sum = 0;
            ch = new boolean[N][N];
            dist = new int[N][N];
            Queue<Point> q = new LinkedList<>();

            // 잠기는 영역 구하기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] > limit){
                        q.add(new Point(i, j));
                        dist[i][j] = 1;
                    }
                }
            }

            int cnt = 1;

            while(!q.isEmpty()){
                Point cur = q.poll();
                if(ch[cur.r][cur.c]){
                    continue;
                }
                ch[cur.r][cur.c] = true;

                for(int i = 0; i < 4; i++){
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if(0 <= nr && nr < N && 0 <= nc && nc < N &&
                            !ch[nr][nc] && dist[nr][nc] == 1){
                        dist[nr][nc] = dist[cur.r][cur.c];
                    }
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    ans = Math.max(ans, dist[i][j]);
                }
            }
        }

        System.out.println(ans);
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