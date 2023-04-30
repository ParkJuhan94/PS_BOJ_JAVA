package WEEK0.P1026;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> arrA;
    static ArrayList<Integer> arrB;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P1026/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arrA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arrB.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arrA);
        Collections.sort(arrB, Collections.reverseOrder());

        int ans = 0;
        for(int i = 0; i < N; i++){
            ans += arrA.get(i) * arrB.get(i);
        }

        System.out.println(ans);
    }

}