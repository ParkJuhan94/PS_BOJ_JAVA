package CODEFORCE.P0612_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        System.setIn(new FileInputStream("src/CODEFORCE/P0612_A/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        //           0  1  3  7  15  31  63
        int[] arr = {1, 2, 4, 8, 16, 32, 64};

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N == 2){
                System.out.println("Bob");
                continue;
            }

            ArrayList<Integer> arrList = new ArrayList<>();
            for(int i = 0; i < N; i++){
                arrList.add(1);
            }
            int cnt = 0;

//            while(true){
//                for(int i = 6; i >= 0; i--){
//
//                }
//            }

            if(cnt % 2 == 0){
                System.out.println("Alice");
            }else{
                System.out.println("Bob");
            }
        }


    }


}