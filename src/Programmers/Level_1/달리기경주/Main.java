package Programmers.Level_1.달리기경주;

import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++){
            String temp = "";
            temp = players[map.get(callings[i]) - 1];
            players[map.get(callings[i]) - 1] =
                    players[map.get(callings[i])];

            players[map.get(callings[i])] = temp;

            map.put(callings[i], map.get(callings[i]) - 1);
            map.put(temp, map.get(temp) + 1);
        }

        return players;
    }
}

public class Main {
    static String[] players = {"mumu","soe","poe","kai","mine"};
    static String[] callings = {"kai", "kai", "mine", "mine"};
    static Solution s = new Solution();

    public static void main(String[] args) {
        String[] result = s.solution(players, callings);

        for(String str : result){
            System.out.println(str);
        }
    }
}
