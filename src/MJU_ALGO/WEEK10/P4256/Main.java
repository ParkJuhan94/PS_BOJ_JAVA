package MJU_ALGO.WEEK10.P4256;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int T;
    static int[] pre, in;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/MJU_ALGO.WEEK10/P4256/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            pre = new int[N+1];
            in  = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                pre[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                in[j] = Integer.parseInt(st.nextToken());
            }

            postorder(0, N, 0);
            System.out.println();
        }
    }

    /*
     전위 순회는 루트부터 시작하고, 중위 순회는 루트를 중심으로 왼쪽 서브트리, 오른쪽 서브트리로 나뉜다

    인덱스 :  0  1 2 3  4    5  6 7
    pre   : [3] 6 5 4  8 / [7] 1 2
    in    :  5  6 8 4 [3]  1 2 [7]

    전위 순회의 첫번째가 3이므로 루트 노드는 3이고
    5 6 8 4 는 왼쪽 서브트리, 1 2 7 은 오른쪽 서브트리이다.
    양 서브트리의 루트(최상단) 노드는 전위 순회의 첫번째 노드 이므로 각각 6, 7 이다.
     */

    // s: 시작 인덱스 e: 마지막 인덱스 r: 트리(서브트리)의 루트 노드의 인덱스
    public static void postorder(int s, int e, int r) {
        for(int i=s; i<e; i++) {
            if(in[i] == pre[r]) {
                postorder(s, i, r+1);              // 1.  왼쪽 서브트리
                // 조합 한 단계 증가할 때 마다 앞 pre[]의 앞 인덱스가 하나씩 사라진다고 생각.
                // r에는 몇 단계인지 저장됨.
                // r = 0, i = 4, s = 0

                // postorder(5, 7, 5)
                // r = 5, s = 5, i = 7
                postorder(i+1, e, r+i-s+1);     // 2. 오른쪽 서브트리
                System.out.print(pre[r] + " ");      // 루트 노드를 출력
            }
        }
    }
}
