package CODEFORCE.Round150.B;

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
        System.setIn(new FileInputStream("src/CODEFORCE/P0612_B/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            int flag = 0;
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] > 1){
                    flag = 1;
                }
            }
            if(flag == 0){
                for(int i = 0; i < N; i++){
                    sb.append(1);
                }
                sb.append("\n");
                continue;
            }

            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            ArrayList<Integer> arrList = new ArrayList<>();
            arrList.add(arr[0]);
            int front1 = arr[0];
            int back1 = arr[0];
            int front2 = 0;
            int back2 = 0;
            int flag2 = 0;

            for(int i = 1; i < N; i++){
                if(arr[i] >= back1 && flag2 == 0){
                    back1 = arr[i];
                    arrList.add(arr[i]);
                    ans.add(1);
                }else{
                    if(arr[i] <= front1 && arr[i] >= front2 &&
                            arr[i] >= back2){
                        flag2 = 1;
                        front2 = arr[i];
                        back2 = arr[i];
                        arrList.add(arr[i]);
                        ans.add(1);
                    }else{
                        ans.add(0);
                    }
                }
            }

            for(int num : ans){
                sb.append(num);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}