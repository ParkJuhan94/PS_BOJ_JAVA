package CODEFORCE.P1130_01;

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
        System.setIn(new FileInputStream("src/CODEFORCE/P1130_01/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0 ; t < T; t++){
            arr.clear();
            N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            for(int i = 0; i < N - 1; i++){
                String str = "";
                str += Character.toString(input.charAt(i));
                str += Character.toString(input.charAt(i + 1));

                if(!arr.contains(str)){
                    arr.add(str);
                }
            }

            System.out.println(arr.size());
        }
    }

}