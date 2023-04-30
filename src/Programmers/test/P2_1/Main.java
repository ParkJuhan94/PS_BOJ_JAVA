package Programmers.test.P2_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = w * h;

        // 세로에 대각선이 걸치는 구간 카운팅해서 (왼, 오) 두 배열에 넣기
        ArrayList<Integer> arr1 = new ArrayList<>();    // 왼
        ArrayList<Integer> arr2 = new ArrayList<>();    // 오

        for(int i = 0; i < w; i++){
            arr1.add((h * i) / w);
            System.out.println(arr1.get(i));
        }

        System.out.println();

        for(int i = 1; i <= w; i++){
            if((h * i) % w == 0){
                arr2.add((h * i) / w);
            }else{
                arr2.add((h * i) / w + 1);
            }
            System.out.println(arr2.get(i - 1));
        }

        long sub = 0;
        for(int i = 0; i < w; i++){
            sub += (arr2.get(i) - arr1.get(i));
        }

        answer -= sub;

        return answer;
    }
}

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK00/P/input.txt"));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        Solution s = new Solution();
        System.out.println(s.solution(8, 12));
    }

}