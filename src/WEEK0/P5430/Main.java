package WEEK0.P5430;

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
        System.setIn(new FileInputStream("src/WEEK0/P5430/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for(int tc = 0; tc < TC; tc++){
            String op = br.readLine();
            N = Integer.parseInt(br.readLine());

            String input = br.readLine();
            input = input.replace("[", "");
            input = input.replace("]", "");
            String[] input_ = input.split(",");
            arr = new ArrayList<>();

            for(int i = 0; i < N; i++){
                arr.add(Integer.parseInt(input_[i]));
            }

            // 연산 시작
            boolean reverse = false;
            for(int i = 0; i < op.length(); i++){
                if(op.charAt(i) == 'R'){
                    // 실제로 뒤집는게 아니라, 방향 변수 reverse 만 역전시켜주고 연산 진행
                    reverse = (reverse == true) ? false : true;

                } else if (op.charAt(i) == 'D'){
                    // 원소가 하나도 없으면 에러 출력

                    // 
                    if(reverse){

                    }else{

                    }
                }

                // 출력

            }

            System.out.println();
        }
    }

}