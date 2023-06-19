package BOJ.Section01.P1541;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> arr;
    static ArrayList<Integer> arrMinus;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section01/P1541/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-+", true);

        arr = new ArrayList<>();
        arrMinus = new ArrayList<>();

        int ans = 0;
        int flag = 0;   // -할지 안할지 : 세션 0 이면 더하기, 1이면 빼기

        while(st.hasMoreTokens()){
            String cur = st.nextToken();

            if(cur.equals("-")){
                flag = 1;
                continue;
            }
            if(cur.equals("+")){
                continue;
            }

            if(flag == 0){
                ans += Integer.parseInt(cur);
            } else {
                ans -= Integer.parseInt(cur);
            }
        }


        System.out.println(ans);
    }

}
