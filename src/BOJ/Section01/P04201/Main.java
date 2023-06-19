package BOJ.Section01.P04201;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String X, Y;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section01/P04201/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        X = br.readLine();
        Y = br.readLine();

        String answer = "";

        int[] tenX = new int[10];
        int[] tenY = new int[10];

        for(int i = 0; i < X.length(); i++){
            tenX[X.charAt(i) - '0']++;
            //System.out.println("X에 ++" + (X.charAt(i) - '0'));
        }
        for(int i = 0; i < Y.length(); i++){
            tenY[Y.charAt(i) - '0']++;
            //System.out.println("Y에 ++" + (Y.charAt(i) - '0'));
        }

        ///////////////

        int min = 0;
        for(int i = 9; i >= 0; i--){
            min = 0;
            if(tenX[i] != 0 && tenY[i] != 0){
                min = Math.min(tenX[i], tenY[i]);
            }

            for(int j = 0; j < min; j++){
                answer += Integer.toString(i);
            }
        }

        if(answer.length() == 0){
            answer = "-1";
        }

        System.out.println(answer);
        //return answer;
    }
}