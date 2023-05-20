package CODEFORCE.P1130_03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        System.setIn(new FileInputStream("src/CODEFORCE/P1130_03/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int[] a = new int[N];
            st = new StringTokenizer(br.readLine());
            int oddCnt = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                a[i] = Integer.parseInt(st.nextToken());
                if(a[i] % 2 == 1){
                    oddCnt++;
                    if(a[i] < min){
                        min = a[i];
                    }
                }
            }

            Arrays.sort(a);

            if(oddCnt == 0 || oddCnt == N){
                sb.append("YES" + "\n");
            }else{
                int flag = 0;
                for(int i = 0; i < N; i++){
                    if(a[i] % 2 == 0){
                        if(a[i] - min < 0){
                            sb.append("NO" + "\n");
                            flag = 1;
                            break;
                        }
                    }
                }
                if(flag == 0){
                    sb.append("YES" + "\n");
                }
            }
        }

        System.out.print(sb);
    }

}