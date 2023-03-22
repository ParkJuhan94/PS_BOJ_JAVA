package KAKAO2022.kakao2;

import java.io.IOException;
import java.util.ArrayList;


class Solution {
    int map[][];
    int ch[];
    int numHomes;
    ArrayList<home> homes;
    long dist;
    long min;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        min = Long.MAX_VALUE;
        dist = 0;
        numHomes = n;
        int cnt = 0;      // 현재 트럭에 실린 상자 갯수
        map = new int[n + 1][n + 1];
        ch = new int[n + 1];
        homes = new ArrayList<>();

        // 인덱스 0에는 물류창고, 1부터 집
        for(int i = 0; i < n; i++){
            homes.add(new home(deliveries[i], pickups[i]));
        }

        for(int i = 1 ; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                map[i][j] = Math.abs(i-j);
                map[j][i] = Math.abs(i-j);
            }
        }

        ch[0] = 1;
        dfs(0);

        return min;
    }

    void dfs(int v){
        // v는 집 번호
        int flag = 0;
        for(int i = 0; i < numHomes + 1; i++){
            if(homes.get(i).isEmpty() == true){
                flag = 1;
            }
        }

        // 집이 아직 남아있으면 계속 진행
        if (flag == 1) {
            if(dist < min){
                min = dist;
            }
        }else{
            for(int i = 1; i < numHomes + 1; i++){
                if(map[v][i] == 1 && ch[i] == 0){
                    // 체크할 조건
                    ch[i] = 1;

                    // 탐색 진행
                    dfs(i);

                    // 체크아웃할 조건
                    ch[i] = 0;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};

        // 16 = 5 + 5 + 3 + 3
        System.out.println(s.solution(cap, n, deliveries, pickups));
    }
}

class home {
    int del;
    int pick;

    public home(int del, int pick) {
        this.del = del;
        this.pick = pick;
    }

    boolean isEmpty(){
        if(del == 0 && pick == 0){
            return true;
        }
        return false;
    }
}
