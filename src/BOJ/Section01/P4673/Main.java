package BOJ.Section01.P4673;

import java.io.IOException;

public class Main {
    static int N;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ.Section02/P/input.txt"));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        ch = new boolean[10001];

        for(int i = 1; i < 10001; i++){
            int n = haveSelfNum(i);
            if(n <= 10000){
                ch[n] = true;
            }
        }

        for(int i = 1; i < 10001; i++){
            if(!ch[i]){
                System.out.println(i);
            }
        }
    }

    static int haveSelfNum(int number){
        int sum = number;

        while(number > 0){
            sum = sum + number % 10;
            number /= 10;
        }

        return sum;
    }

}