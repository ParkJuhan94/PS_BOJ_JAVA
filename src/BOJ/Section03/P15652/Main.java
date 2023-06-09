package BOJ.Section03.P15652;

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
    static int[] selected;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section03/P15652/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        dfs(1, 0);
    }

    static void dfs(int start, int count){
        if(count == M){
            for(int num : selected){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++){
            selected[count] = i;
            dfs(i, count + 1);
        }
    }

}