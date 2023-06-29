package BOJ.Section04.P2733;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Character> word = new ArrayList<>(32768);
    static int point;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/Section04/P2733/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; t++){






            System.out.println("PROGRAM #" + t + ":");
            System.out.println(sb);
        }
    }

    static void beforeEach(){
        sb = new StringBuilder();
        for(int i = 0; i < 32768; i++){
            word.set(i, '0');
        }
        point = 0;
    }

}