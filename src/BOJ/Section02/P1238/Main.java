package BOJ.Section02.P1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int X;
    static int[][] map;
    //static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static ArrayList<ArrayList<Node>> adj;
    static int[] ch;
    static int[] dist;  //최단 거리 테이블
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section02/P1238/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        dist = new int[N + 1];
        ch = new int[N + 1];
        for(int i = 0 ; i < N + 1; i++){
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj.get(s).add(new Node(e, d));
        }

        int sum = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 0 ; j < N + 1; j++){
                dist[j] = Integer.MAX_VALUE;
            }
            ch = new int[N + 1];
            dijkstra(i);
            sum = 0;
            sum += dist[X];

            for(int j = 0 ; j < N + 1; j++){
                dist[j] = Integer.MAX_VALUE;
            }
            ch = new int[N + 1];
            dijkstra(X);
            sum += dist[i];

            if(sum > ans){
                ans = sum;
            }
        }

        //System.out.print(sb);
        System.out.println(ans);
    }

    static void dijkstra(int start) {
        //우선 순위 큐 사용, 가중치를 기준으로 오름차순
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        //시작 노드에 대해서 초기화
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            //현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리 한다.
            Node now = q.poll();

            if (ch[now.v] == 0) {
                ch[now.v] = 1;
            }

            for (Node next : adj.get(now.v)) {
                //방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
                if (ch[next.v] == 0 && dist[next.v] > now.cost + next.cost) {
                    // 갱신하고 add
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

class Node{
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}