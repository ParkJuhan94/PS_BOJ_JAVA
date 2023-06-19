package CODEFORCE.Round874.B;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        System.setIn(new FileInputStream("src/CODEFORCE/P1130_02/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int[] a;
        int[] b;

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = new int[N];
            int[] tmpA = new int[N];
            b = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                a[i] = Integer.parseInt(st.nextToken());
                tmpA[i] = a[i];
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(tmpA);
            Arrays.sort(b);
            int key;

            ArrayList<Integer>[] mapArray = new ArrayList[100000000];
            ArrayList<Integer>[] mapArray2 = new ArrayList[100000000];

            for(int i = 0; i < N; i++){
                key = tmpA[i];
                int value = b[i];

                if(key >= 0){
                    if (mapArray[key] == null) {
                        mapArray[key] = new ArrayList<>();
                    }
                    mapArray[key].add(value);
                }else{
                    if (mapArray2[-1 * key] == null) {
                        mapArray2[-1 * key] = new ArrayList<>();
                    }
                    mapArray2[-1 * key].add(value);
                }
            }

            for(int i = 0; i < N; i++){
                if(a[i] >= 0){
                    ArrayList<Integer> cur = mapArray[a[i]];
                    sb.append(cur.get(0)).append(" ");

                    if(cur.size() > 1){
                        cur.remove(0);
                    }
                } else {
                    ArrayList<Integer> cur = mapArray2[-1 * a[i]];
                    sb.append(cur.get(0)).append(" ");

                    if(cur.size() > 1){
                        cur.remove(0);
                    }
                }

            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}