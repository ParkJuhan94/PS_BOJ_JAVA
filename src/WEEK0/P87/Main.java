package WEEK0.P87;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] ch;
    static int[] dx = {-1,0,1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,-1,1,1,-1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P87/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ch = new int[N][N];
        Queue<Point> q = new LinkedList<>();
        int cnt = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
                if(map[i][j] == 1){
                    q.add(new Point(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Point cur = q.poll();
            int flag = 0;

            for(int i = 0; i < 8; i++){
                int xx = cur.x + dx[i];
                int yy = cur.y + dy[i];

                if(0 <= xx && xx < N && 0 <= yy && yy < N &&
                        map[xx][yy] == 1 && ch[xx][yy] == 0){
                    ch[xx][yy] = cnt;
                    flag = 1;
                }
            }

            if(flag == 1){
                cnt++;
            }
        }

        System.out.println(cnt);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(ch[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}