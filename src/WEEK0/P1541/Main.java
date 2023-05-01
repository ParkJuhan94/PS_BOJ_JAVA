package WEEK0.P1541;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P1541/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-+");

        arr = new ArrayList<>();
        while(st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }

//        for(int i = 0; i < arr.size(); i++){
//            System.out.println(arr.get(i));
//        }

        
    }

}