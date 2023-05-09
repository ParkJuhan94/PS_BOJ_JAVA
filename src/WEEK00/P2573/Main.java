package WEEK00.P2573;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P2573/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            search();
        }



        System.out.println(ans);
    }

    static void search(){
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(map[r][c] == 0){
                    for(int k = 0; k < 4; k++){
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0){
                            map[nr][nc]--;
                        }
                    }

                }
            }
        }

        ans++;
    }

}