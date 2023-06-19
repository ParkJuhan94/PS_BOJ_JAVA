package BOJ.Section03.P1946;

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
        System.setIn(new FileInputStream("src/BOJ.Section03/P1946/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            int[] score = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());

                // 서류 순위를 인덱스로, 면접 순위를 값으로 저장
                score[score1 - 1] = score2;
            }

            int cnt = 1;    // 합격자 수 : 서류 1위는 합격 fix
            int minInterviewScore = score[0];   // 합격자들 중, 면접 순위의 최솟값

            for (int i = 1; i < N; i++) {
                if (score[i] < minInterviewScore) {
                    cnt++; // 면접심사 성적이 현재 합격자들 중에서 최소값보다 작은 경우 합격
                    minInterviewScore = score[i]; // 면접심사 성적 최소값 업데이트
                }
            }

            System.out.println(cnt);
        }


    }

}