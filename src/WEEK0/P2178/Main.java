package WEEK0.P2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dc;
    static int[] dr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P2178/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
           for(int j = 0; j < M; j++){
               map[i][j] = Integer.parseInt(Character.toString(input.charAt(j)));
           }
        }



    }

    void search(){
        
    }

}