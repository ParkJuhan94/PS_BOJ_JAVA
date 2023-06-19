package BOJ.Section02.P12851;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visited = new int[100001]; // 방문 여부를 체크하기 위한 배열
    static int cnt = 0;
    static int min = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section02/P12851/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);

        System.out.println(visited[k]);
        System.out.println(cnt);
    }

    public static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start); // 시작 위치를 큐에 삽입
        visited[start] = 0; // 시작 위치를 방문 처리

        while (!q.isEmpty()) {
            int cur = q.poll(); // 현재 위치를 큐에서 추출

            if (cur == end) {
                if(cnt == 0){
                    min = visited[cur];
                }
                if(visited[cur] == min){
                    cnt++;
                }
                continue;
            }

            int[] next = {cur - 1, cur + 1, cur * 2};

            for (int i = 0; i < 3; i++) {
                if (next[i] >= 0 && next[i] <= 100000) {
                    // 1. 방문하지 않은 위치인 경우
                    // 2. 이미 방문한 위치이지만 최소 시간과 같은 경우 경우
                    if (visited[next[i]] == 0 || visited[next[i]] == visited[cur] + 1) {
                        q.offer(next[i]);
                        visited[next[i]] = visited[cur] + 1; // 최소 시간 갱신
                    }
                }
            }
        }
    }
}