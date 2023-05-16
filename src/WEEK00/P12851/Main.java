package WEEK00.P12851;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK00/P12851/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int[] map = new int[100001];
        int[] ch = new int[100001];
        q.add(N);
        ch[N] = 1;
        int ans = 0;
        int ans1 = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == K){
                ans = map[cur];
                break;
            }

            if(cur * 2 == cur + 1 || cur * 2 == cur - 1){
                ans1++;
            }


            if(cur * 2 <= 100000 && ch[cur * 2] == 0){
                q.add(cur * 2);
                map[cur * 2] = map[cur] + 1;
                ch[cur * 2] = ch[cur] + 1;
            }

            if(cur - 1 >= 0 && ch[cur - 1] == 0){
                q.add(cur - 1);
                map[cur - 1] = map[cur] + 1;
                ch[cur - 1] = ch[cur] + 1;
            }

            if(cur + 1 <= 100000 && ch[cur + 1] == 0){
                q.add(cur + 1);
                map[cur + 1] = map[cur] + 1;
                ch[cur + 1] = ch[cur] + 1;
            }
        }

        System.out.println(ans);
        System.out.println(ans1);
    }
}