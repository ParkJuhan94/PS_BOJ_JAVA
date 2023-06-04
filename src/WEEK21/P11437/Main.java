package WEEK21.P11437;

//import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] parents;
    static int[] depths;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK21/P11437/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        parents = new int[N+1];
        depths = new int[N+1];
        Arrays.fill(depths,-1);

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        dfs(1,1,0);//레벨 및 부모 노드 저장

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCA(a, b));
        }
    }

    public static int LCA(int a, int b){
        int aDepth = depths[a];
        int bDepth = depths[b];
        // 깊이 맞추기
        while(aDepth>bDepth){
            a = parents[a];
            aDepth--;
        }
        while(bDepth>aDepth){
            b = parents[b];
            bDepth--;
        }

        // 깊이는 같은데 부모가 다를 경우 -> 같을 때 까지 양 노드를 부모 노드로 바꿔주기
        while(a!=b){
            a = parents[a];
            b = parents[b];
        }
        return a;
    }

    // 깊이 + 부모를 저장
    public static void dfs(int current, int depth, int parent){
        depths[current] = depth;
        parents[current] = parent;
        // 연결된 노드를 탐색
        for(int nextNode : tree[current]){
            if(nextNode != parent){
                dfs(nextNode,depth+1,current);
            }
        }
    }
}




import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
