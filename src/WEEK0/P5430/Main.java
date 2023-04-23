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
            int startIdx = 0;
            int endIdx = arr.size() - 1;

            for(int i = 0; i < op.length(); i++){
                if(op.charAt(i) == 'R'){
                    // 실제로 뒤집는게 아니라, 방향 변수 reverse 만 역전시켜주고 연산 진행
                    reverse = (reverse == true) ? false : true;
                } else if (op.charAt(i) == 'D'){
                    // 원소가 하나도 없으면 에러 출력
                    if(startIdx > endIdx){
                        System.out.println("error");
                        break;
                    }

                    // 원소가 하나라도 있으면 삭제
                    // 실제로 remove 를 하면 시간초과!!!
                    if(reverse){
                        //arr.remove(arr.size() - 1);
                        endIdx--;
                    }else{
                        //arr.remove(0);
                        startIdx++;
                    }
                }
            }

            // 출력
            if(startIdx < endIdx){
                System.out.print("[");
                if(reverse){
                    for(int i = endIdx; i >= startIdx; i--){
                        System.out.print(arr.get(i));
                        if(i != startIdx){
                            System.out.print(",");
                        }
                    }
                }else{
                    for(int i = startIdx; i <= endIdx; i++){
                        System.out.print(arr.get(i));
                        if(i != endIdx){
                            System.out.print(",");
                        }
                    }
                }
                System.out.println("]");
            }
        }
    }

}