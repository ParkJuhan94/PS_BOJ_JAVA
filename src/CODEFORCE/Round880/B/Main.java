package CODEFORCE.Round880.B;

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

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/CODEFORCE/Round880/B/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long k = Integer.parseInt(st.nextToken());
            long g = Integer.parseInt(st.nextToken());

            if(k == 0 || n == 1){
                System.out.println(0);
                continue;
            }

            long limit = k * g;
            long half = (g % 2 == 0) ? g/2-1 : g/2;

            long multi = Math.min(half * n, limit);
            long mod = ((limit - multi) % g == 0) ?
                    (limit - multi) / g : (limit - multi) / g + 1;

            long ans = limit - g * mod;
            if(ans < 0){
                System.out.println(0);
            }else{
                System.out.println(ans);
            }
        }
    }

}