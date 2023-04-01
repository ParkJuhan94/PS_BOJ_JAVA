package WEEK10.P10816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK10/P10816/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //가지고 있는 숫자 카드의 개수
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 가지고 있는 카드의 배열
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine()); //판별해야할 숫자의 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            //System.out.println("low: " + lowerBound(arr, key) + " up: " + upperBound(arr, key));
            sb.append(upperBound(arr, key) - lowerBound(arr, key) + " ");
        }
        System.out.println(sb);
    }

    //오름차순 배열에서 찾고자 하는 값이 처음으로 나타나는 위치
    static int lowerBound(int[] arr, int key){
        int lt = 0;
        int rt = arr.length;
        int mid;

        while(lt < rt){
            mid = (lt + rt) / 2;

            if(key <= arr[mid]){        // key 와 같을 때 상한선 내려
                rt = mid;
            }else{
                lt = mid + 1;
            }
        }
        return lt;
    }
    
    //오름차순 배열에서 찾고자 하는 값 초과의 값이 처음으로 나타나는 위치
    static int upperBound(int[] arr, int key){
        int lt = 0;
        int rt = arr.length;
        int mid;

        while(lt < rt){
            mid = (lt + rt) / 2;

            if(key < arr[mid]){     // key 와 같을 때 하한선 올려
                rt = mid;
            }else{
                lt = mid + 1;
            }
        }
        return lt;
    }
}