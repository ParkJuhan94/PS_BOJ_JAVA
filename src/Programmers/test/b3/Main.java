package Programmers.test.b3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    char[][] map;
    boolean[][] ch;
    int maxR, maxC;
    int[] dr = {1, 0, -1, 0, -1, -1, 1, 1};
    int[] dc = {0, -1, 0, 1, 1, -1, -1, 1};

    class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public String[] solution(String[] board, int y, int x) {
        String[] answer = new String[board.length];
        int r = y;
        int c = x;
        maxR = board.length;
        maxC = board[0].length();
        map = new char[maxR][maxC];
        ch = new boolean[maxR][maxC];

        for(int i = 0; i < maxR; i++){
            for(int j = 0; j < maxC; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        if(board[r].charAt(c) == 'M'){  // 처음 눌러서 게임오버
            String tmp = "";

            for(int i = 0; i < board.length; i++){
                if(i != r){
                    answer[i] = board[i];
                }else{
                    for(int j = 0; j < board[r].length(); j++){
                        if(j == c){
                            tmp += "X";
                        }else{
                            tmp += Character.toString(board[i].charAt(j));
                        }
                    }
                    answer[i] = tmp;
                }
            }
        }else{
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(r, c));
            ch[r][c] = true;

            while(!q.isEmpty()){
                Point cur = q.poll();
                ch[cur.r][cur.c] = true;

                if(numMine(cur.r, cur.c) == 0){
                    for(int i = 0; i < 8; i++){
                        int nr = cur.r + dr[i];
                        int nc = cur.c + dc[i];

                        if(0 <= nr && nr < maxR && 0 <= nc && nc < maxC
                                && map[nr][nc] == 'E' && !ch[nr][nc]){
                            q.add(new Point(nr, nc));
                        }
                    }
                }else{
                    map[cur.r][cur.c] = (char) (numMine(cur.r, cur.c) + '0');
                }
            }
        }

        // map을 answer로 변환
        for(int i = 0; i < maxR; i++){
            String str = "";
            for(int j = 0; j < maxC; j++){
                str += Character.toString(map[i][j]);
            }
            answer[i] = str;
        }

        return answer;
    }

    int numMine(int r, int c){
        int cnt = 0;

        for(int i = 0; i < 8; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(0 <= nr && nr < maxR && 0 <= nc && nc < maxC
                    && map[nr][nc] == 'M'){
                cnt++;
            }
        }

        if(cnt == 0){
            map[r][c] = 'B';
        }else{
            map[r][c] = (char) (cnt + '0');
        }

        return cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        String[] board1 = {"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
        String[] board2 = {"MME", "EEE", "EME"};

        String[] ans = (s.solution(board1, 2, 0));
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
        System.out.println();

        ans = (s.solution(board2, 0, 0));
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}