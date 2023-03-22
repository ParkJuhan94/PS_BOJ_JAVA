package SAMSUNG.PS02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    static String n;
    static int x, y;
    static int[] ten;
    static int ans, big, small;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/SAMSUNG/PS02/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = st.nextToken();
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            ten = new int[10];
            ans = 0;
            int digit = 1;

            if(x > y){
                big = x;
                small = y;
            } else {
                big = y;
                small = x;
            }

            // digit 자릿수 만들기
            int tmp = n.length();
            while(tmp-- > 1){
                digit *= 10;
            }

            int flag1 = 0;   // big과 small 사이 걸렸을 때 밑에 자릿수를 전부 big으로 처리하기 위함
            int flag2 = 0;   // big 초과 걸렸을 때 밑에 자릿수를 전부 big으로 처리하기 위함

            if(isPossible(n, small) && n.length() >= 1){
                for(int i = 0; i < n.length(); i++){
                    if(n.charAt(i) - '0' >= big || flag1 == 1 || flag2 == 1){
                        ans += big * digit;
                        ten[big]++;
                        ten[small]++;

                        if(n.charAt(i) - '0' > big){
                            flag2 = 1;
                        }
                    } else if(n.charAt(i) - '0' >= small){
                        ans += small * digit;
                        ten[small]++;

                        if(n.charAt(i) - '0' > small){
                            flag1 = 1;
                        }
                    }

                    digit /= 10;
                }

                // 예외처리
                if(ten[big] == 0 && ten[small] == 0){
                    ans = -1;
                }
                if(ans == 0){
                    ans = -1;
                }
            }else{
                digit /= 10;
                for(int i = 0; i < n.length() - 1; i++){
                    ans += big * digit;
                    ten[big]++;
                    ten[small]++;

                    digit /= 10;
                }
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }

    static boolean isPossible(String n, int small){
        int flag = 0;

        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) - '0' < small){
                flag = 1;
            }
        }

        if(flag == 0){
            return true;
        }else{
            return false;
        }
    }
}