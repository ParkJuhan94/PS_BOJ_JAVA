package 현대모비스예선.P1;

import java.util.*;

class Req {
    int start;
    int playtime;       // 남은 잔여시간의 의미도 됨
    int type;

    public Req(int start, int playtime, int type) {
        this.start = start;
        this.playtime = playtime;
        this.type = type;
    }
}

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = Integer.MAX_VALUE;

        ArrayList<Req> reqList = new ArrayList<>();
        for(int i = 0; i < reqs.length; i++){
            reqList.add(new Req(reqs[i][0], reqs[i][1], reqs[i][2]));
        }

        int now = 0;
        int[] numCounsel = new int[k + 1];
        Arrays.fill(numCounsel, 1);

        Stack<Req> s = new Stack<>();

        // 상담원 배정 시뮬레이션
        for(int r = 0; r < n - k; r++){

            int max = 0;    // type 중에서 최대 대기시간
            int plusIdx = 0;    // 상담원 늘려줄 type 의 인덱스
            for(int i = 1; i <= k; i++){
                int startTime = 0;  // 상담원 여유가 생기는 시각
                int waitTime = 0;
                int counsel = 0;       // 진행중인 상담 갯수

                s = new Stack<>();

                for (Req req : reqList) {
                    if (req.type == i) {
                        s.add(req);
                    }
                }

                now = s.peek().start;

                while(!s.isEmpty()){
                    Req cur = s.pop();

                    if(counsel < numCounsel[i] + 1){    // 남은 상담원 있다면
                        counsel++;
                        if(counsel == numCounsel[i] + 1){
                            startTime = Math.min(startTime, cur.start + cur.playtime);
                        }
                    }else{  // 남은 상담원 없다면
                        s.add(cur);
                    }
                }


            }
        }

        return answer;
    }
}

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {
        int[][] reqs = {
                {10, 60, 1},
                {15, 100,3},
                {20,30,1},
                {30,50,3},
                {50,40,1},
                {60,30,2},
                {65,30,1},
                {70,100,2},
        };

        System.out.println(s.solution(3,5,reqs));
    }
}
