package MJU_ALGO.WEEK14.P3197;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, res;
    static char[][] map;
    static int[][] ch, ch2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Point[] swans;
    static Queue<Point> qWater;
    static Queue<Point> qSwan;
    static Queue<Point> qSwanTemp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/MJU_ALGO/WEEK14/P3197/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        swans = new Point[2];
        qWater = new LinkedList<>();
        qSwan = new LinkedList<>();
        qSwanTemp = new LinkedList<>();
        map = new char[R][C];
        ch = new int[R][C];
        ch2 = new int[R][C];
        char input;
        String inputStr;
        int swanIdx = 0;

        for(int i = 0; i < R; i++){
            inputStr = br.readLine();
            for(int j = 0; j < C; j++){
                input = inputStr.charAt(j);
                map[i][j] = input;

                if(input == '.') {
                    qWater.add(new Point(i, j));
                    ch[i][j] = 1;
                }
                if(input == 'L') { swans[swanIdx++] = new Point(i, j); }
            }
        }

        res = 0;
        qSwanTemp.add(new Point(swans[0].x, swans[0].y));
        ch2[swans[0].x][swans[0].y] = 1;

        while(true){
            if(isPossible()) break;
            oneDay();
            res++;
            printMap();
        }
        System.out.println(res);
    }

    // 하루 지나서 물이 얼음을 녹이는 시뮬레이션
    static void oneDay(){

        int size = qWater.size();
        for(int i = 0; i < size; i++){
            Point cur = qWater.poll();

            for(int j = 0; j < 4; j++){
                int xx = cur.x + dx[j];
                int yy = cur.y + dy[j];

                if(0 <= xx && xx < R && 0 <= yy && yy < C &&
                        map[xx][yy] == 'X' && ch[xx][yy] == 0){
                    map[xx][yy] = '.';
                    ch[xx][yy] = 1;                         // 새로 생긴 물을 체킹
                    qWater.add(new Point(xx, yy));    // 새로 생긴 물을 경계점에 넣어줌
                }
            }
        }
    }

    // 백조 둘이 만날 수 있는지 반환(bfs)
    static boolean isPossible(){
        qSwan = new LinkedList<>(qSwanTemp);

        while(!qSwan.isEmpty()){
            Point cur = qSwan.poll();

            for(int i = 0; i < 4; i++){
                int xx = cur.x + dx[i];
                int yy = cur.y + dy[i];

                if(0 <= xx && xx < R && 0 <= yy && yy < C
                        && ch2[xx][yy] == 0){

                    if(xx == swans[1].x && yy == swans[1].y) return true;

                    ch2[xx][yy] = 1;

                    if(map[xx][yy] == 'X'){
                        //map[xx][yy] = '.';
                        qSwanTemp.add(new Point(xx, yy));   // temp에 넣어서 보관한다.
                        //System.out.println("qSwan 추가 :" + xx + ", " + yy);
                    }else{
                        qSwan.add(new Point(xx, yy));
                    }

                }
            }
        }

        return false;
    }

    static void printMap(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}