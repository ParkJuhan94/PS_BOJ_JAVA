package CODEFORCE.Round880.C;

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
        System.setIn(new FileInputStream("src/CODEFORCE/P0618_C/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int a = A;
            int B = Integer.parseInt(st.nextToken());
            int b = B;
            int C = Integer.parseInt(st.nextToken());
            int c = C;
            int k = Integer.parseInt(st.nextToken());

            int flag = 0;
            for(int i = 0; i < k; i++){
                b++;
                if(cntDigit(b) > B){
                    a++;
                    for(int j = 0; j < B - 1; j++){
                        b *= 10;
                    }
                }
                if(cntDigit(a) > A){
                    flag = 1;
                    break;
                }
                c++;
                if(cntDigit(c) > C){
                    flag = 1;
                    break;
                }
            }



            if(flag == 1){
                System.out.println(-1);
            }else{
                System.out.println(a + " + " + b + " = " + c);
            }
        }
    }

    static int cntDigit(int n){
        int res = 0;

        while(true){
            res++;
            n /= 10;

            if(n == 0){
                return res;
            }
        }
    }

}