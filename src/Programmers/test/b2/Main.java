package Programmers.test.b2;

import java.io.IOException;
import java.math.BigInteger;

class Solution {
    public int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        BigInteger sum = new BigInteger("0");
        BigInteger mod = new BigInteger("10000019");

        int[][] dp = new int[251][251];
        dp[1][1] = 2;
        for(int i = 0; i < 251; i++){
            dp[0][i] = 1;
            dp[i][0] = 1;
        }
        for(int i = 2; i < 251; i++){
            dp[1][i] = i + 1;
            dp[i][1] = i + 1;
        }
        for(int i = 2; i < 251; i++){
            for(int j = 2; j < 251; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for(int[] dia : diagonals){
            int tmp =  dp[dia[0]][dia[1] - 1] * dp[width - dia[0]][height - dia[1] + 1]
                    + dp[dia[0] - 1][dia[1]] * dp[width - dia[0] + 1][height - dia[1]];

            sum = sum.add(new BigInteger(Integer.toString(tmp)));
        }

        answer = sum.remainder(mod).intValue();
        //answer = sum.intValue();
        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int[][] diagonals1 = {{1,1}, {2,2}};
        int[][] diagonals2 = {{17,19}};
        int[][] diagonals3 = {{2,1}};

        System.out.println(s.solution(2, 2, diagonals1));     // 12
        System.out.println(s.solution(51, 37, diagonals2));   // 3225685
        System.out.println(s.solution(3, 2, diagonals3));   // 3225685
    }
}