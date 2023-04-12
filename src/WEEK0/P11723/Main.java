package WEEK0.P11723;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P11723/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[21];
        int bitset = 0;
        /*
            int 자료형 a를 선언하면 4바이트(4 * 8bit)를 메모리에 할당받아
            총 32개에 대에 참, 거짓을 판단할 수 있게 된다.
            a = 00000000 00000000 00000000 00000000(2)로 메모리에 할당받는다.
         */

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int num = 0;

            if(order.equals("add") || order.equals("remove")
                    || order.equals("check") || order.equals("toggle")){
                num = Integer.parseInt(st.nextToken());
            }

            if(order.equals("add"))
            {
                // num - 1인 이유는 20이 들어왔을 때
                // 2^19 자리가 20번째이기 때문이다.
                bitset |= (1 << (num - 1));
            }
            else if(order.equals("remove"))
            {
                bitset = bitset & ~(1 << (num - 1));
            }
            else if(order.equals("check"))
            {
                sb.append((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
            }
            else if(order.equals("toggle"))
            {
                bitset = bitset ^ (1 << (num - 1));     //어렵다. xor
            }
            else if(order.equals("all"))
            {
                bitset |= (~0);
            }
            else if(order.equals("empty"))
            {
                bitset &= 0;
            }
        }
        System.out.println(sb.toString());
    }

}