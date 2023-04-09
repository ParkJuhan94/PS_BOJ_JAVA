package WEEK0.P1158;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P1158/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
    }

}