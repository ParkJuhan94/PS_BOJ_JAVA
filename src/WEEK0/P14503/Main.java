package WEEK0.P14503;

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
    //방향은 후진 기준으로 0부터 3까지 차례대로 배치
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, 1, 0};
    static int startX, startY, direction;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P14503/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new int[N][M];
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        ch[startX][startY] = 1;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(startX, startY, direction);

        System.out.println(ans);
    }

    static void search(int x, int y, int direction){
        if(ch[x][y] == 0){
            ch[x][y] = 1;
            ans++;
        }

        //현재 칸의 주변 4칸 확인
        for(int i = 0; i < 4; i++){
            direction = (direction + 3) % 4;  //중요. 반시계 90도 회전
            int xx = x + dx[direction];
            int yy = y + dy[direction];

            if(0 <= xx && xx < N && 0 <= yy && yy < M
                    && map[xx][yy] == 0 && ch[xx][yy] == 0){
                ch[xx][yy] = 1;
                ans++;
                search(xx, yy, direction);
            }
        }

        //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        int xx = x - dx[direction];
        int yy = y - dy[direction];
        if(0 <= xx && xx < N && 0 <= yy && yy < M 
                && map[xx][yy] == 0){
            //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            search(xx, yy, direction);
        }else{
            //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        }

    }
}