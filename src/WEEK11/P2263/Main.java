package WEEK11.P2263;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] in, post;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK11/P2263/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        post = new int[N+1];
        in = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++){
            in[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++){
            post[j] = Integer.parseInt(st.nextToken());
        }

        preorder(0, N, N - 1);
        System.out.println();
    }

    // s: 시작 인덱스 e: 마지막 인덱스 r: 트리(서브트리)의 루트 노드의 인덱스
    public static void preorder(int s, int e, int r) {
        for(int i=s; i<e; i++) {
            if(in[i] == post[r]) {
                System.out.print(post[r] + " ");      // 루트 노드를 출력

                //"right에서 돈 횟수"만큼 rootIndex를 감소시켜야 함
                //e - i : right에서 돈 횟수(루트 우측 개수만큼 돔)
                // r - (e - i) = r + i - e
                preorder(s, i, r + i - e);         // 1.  왼쪽 서브트리

                // 재귀 한 단계 증가할 때 마다 앞 pre[]의 앞 인덱스가 하나씩 사라진다고 생각.
                // r에는 몇 단계인지 저장됨.
                preorder(i+1, e, r - 1);        // 2. 오른쪽 서브트리
            }
        }
    }
}
