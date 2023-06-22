package Programmers.Level_0.옹알이_1;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "0");
            babbling[i] = babbling[i].replace("woo", "0");
            babbling[i] = babbling[i].replace("ye", "0");
            babbling[i] = babbling[i].replace("ma", "0");
            babbling[i] = babbling[i].replace("0", "");

            if(babbling[i].equals("")) answer++;
        }

        return answer;
    }
}

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {

    }
}

