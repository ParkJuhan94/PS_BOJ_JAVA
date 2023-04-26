package WEEK0.P14500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P14500/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
               if(search(i, j) > ans){
                   ans = search(i, j);
               }
            }
        }

        System.out.println(ans);
    }

    // x행 y열에서 시작하는 테트로미노 15가지 중에서(회전 포함) 최대의 합을 return
    static int search(int x, int y){
        int max = 0;

        for(){

        }

        return max;
    }

}