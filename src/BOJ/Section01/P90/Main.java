package BOJ.Section01.P90;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section01/P90/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        //N = Integer.parseInt(st.nextToken());

        String input;
        while(!(input = br.readLine()).equals("0")){
            int len = input.length();
            int flag = 0;
            for(int i = 0; i < len / 2; i++){
                if(input.charAt(i) != input.charAt(len - i - 1)){
                    flag = 1;
                }
            }

            if(flag == 1){
                System.out.println("no");
            } else {
                System.out.println("yes");
            }


        }



//        int ans = 0;
//        System.out.println(ans);
    }
}
