package Programmers.test.b1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] boxes, int m, int k) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int box : boxes){
            arr.add(box);
        }
        Collections.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            for(int box : arr){
                int pay = (m / 10000) * box;

                if(pay <= 100000){
                    m += pay;
                    break;
                }
            }
        }

        answer = m;
        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int[] boxes1 = {1000, 800, 900};
        int[] boxes2 = {9000, 10000, 8520, 9500};

        System.out.println(s.solution(boxes1, 1000000, 3)); // 1294200
        System.out.println(s.solution(boxes2, 110000, 4));  // 209000
    }
}