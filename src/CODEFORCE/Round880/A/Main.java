package CODEFORCE.Round880.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
        System.setIn(new FileInputStream("src/CODEFORCE/P0618_A/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int[] cntArr = new int[100];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                cntArr[arr[i]]++;
            }

            Arrays.sort(arr);

            int limit = arr[arr.length - 1];
            int max = cntArr[0];
            int flag = 0;

            for(int i = 0; i <= limit; i++){
                if(cntArr[i] > max || max == 0){
                    System.out.println("NO");
                    flag = 1;
                    break;
                }
                max = cntArr[i];
            }

            if(flag == 1){
                continue;
            }

            System.out.println("YES");

        }

    }

}