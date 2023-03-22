package SAMSUNG.PS01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] alpha;
    static char[][] map;
    static int ans;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/SAMSUNG/PS01/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            alpha = new int[26];
            ans = 0;

            for(int i = 0; i < R; i++){
                String strInput = br.readLine();
                for(int j = 0; j < C; j++){
                    map[i][j] = strInput.charAt(j);
                }
            }

            alpha[map[0][0] - 'A'] = 1;
            search(0, 0, 1);

            System.out.println("#" + test_case + " " + ans);
        }
    }

    static void search(int x, int y, int sum){
        int flag = 0;

        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(0 <= xx && xx < R && 0 <= yy && yy < C && alpha[map[xx][yy] - 'A'] == 0){
                alpha[map[xx][yy] - 'A']++;
                search(xx, yy, sum + 1);
                alpha[map[xx][yy] - 'A']--;

                flag = 1;
            }
        }

        if(flag == 0){
            if(sum > ans){
                ans = sum;
            }
            return;
        }
    }
}