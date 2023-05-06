package Programmers.test.완주하지못한선수;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < participant.length; i++){
            if(!map.containsKey(participant[i])){
                map.put(participant[i], 1);
            }else{
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }

        for(String str : completion){
            map.put(str, map.get(str) - 1);
        }

        for(String str : participant){
            if(map.get(str) == 1) {
                answer = str;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(s.solution(participant, completion));
    }
}

