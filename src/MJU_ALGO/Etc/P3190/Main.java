package MJU_ALGO.Etc.P3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int r, c;
    static int L;
    static int[][] map;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static List<int[]> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];    // 1부터 ~ N으로 인덱스 잡기

        snake = new LinkedList<int[]>();
        snake.add(new int[] { 1, 1 });

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        L = Integer.parseInt(br.readLine());
        Map<Integer, String> dir = new HashMap<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            dir.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        System.out.println(search(1, 1, 0, dir));
    }

    // 뱀의 진행 방향을 넘기기 위한 nowDir
    private static int search(int y, int x, int nowDir, Map<Integer, String> dir) {
        int time = 0; // 현재 진행 시간(반환값)

        while(true) {
            time++; // 루프 한번마다 ++
            int nx = x + dx[nowDir];
            int ny = y + dy[nowDir];

            // 조건 1 : 벽에 부딪힐 때
            if(nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) break;

            // 조건 2 : 자신의 몸에 머리가 부딪히면
            for (int i = 0; i < snake.size(); i++) {
                if(nx == snake.get(i)[1] && ny == snake.get(i)[0])
                    return time;
            }

            if(map[ny][nx] == 1) {      // 사과일 경우
                map[ny][nx] = 0;        // 사과를 먹는다
                snake.add(new int[] {ny, nx});      // 뱀의 길이가 길어짐
            }else {
                snake.add(new int[] {ny, nx});      // 뱀이 움직임
                snake.remove(0);              // 원래 있던 꼬리 부분을 없앰
            }

            x = nx; // 현재 이동 좌표
            y = ny; // 현재 이동 좌표

            //int nx = x + dx[nowDir];
            //int ny = y + dy[nowDir];
            //                    0  1  2   3
            //static int[] dx = { 1, 0, -1, 0 };
            //static int[] dy = { 0, 1, 0, -1 };

            if(dir.containsKey(time)) { // dir에 time과 같은 경우가 있으면
                if(dir.get(time).equals("D")) { // D일 경우
                    nowDir++; // 오른쪽으로 턴
                    if(nowDir == 4) { // 다시 0으로
                        nowDir = 0;
                    }
                }
                else if(dir.get(time).equals("L")) { // L일 경우
                    nowDir--; // 왼쪽으로 턴
                    if(nowDir == -1) { // 다시 3으로
                        nowDir = 3;
                    }
                }
            }
        }
        return time;
    }
}
