package WEEK00.P2212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
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
        System.setIn(new FileInputStream("src/WEEK00/P2212/input.txt"));

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 센서의 개수
        int K = scanner.nextInt(); // 집중국의 개수

        int[] sensors = new int[N]; // 센서들의 좌표를 저장하는 배열

        for (int i = 0; i < N; i++) {
            sensors[i] = scanner.nextInt(); // 센서의 좌표
        }

        if (K >= N) {
            System.out.println(0); // 집중국의 개수가 센서의 개수보다 많거나 같은 경우, 거리의 합은 0
        } else {
            Arrays.sort(sensors); // 센서들을 오름차순으로 정렬

            int[] distances = new int[N - 1]; // 인접한 센서 사이의 거리를 저장하는 배열

            for (int i = 0; i < N - 1; i++) {
                distances[i] = sensors[i + 1] - sensors[i]; // 인접한 센서 사이의 거리 계산
            }

            Arrays.sort(distances); // 거리들을 오름차순으로 정렬

            int answer = 0; // 거리의 합

            for (int i = 0; i < N - K; i++) {
                answer += distances[i]; // 가장 긴 거리부터 K-1번 제거하여 거리의 합 계산
            }

            System.out.println(answer);
        }
    }
}