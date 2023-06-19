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
    static ArrayList<Point> L;
    static Queue<Point> boundary;
    static Queue<Point> boundaryPossible;
    static Queue<Point> Q;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/MJU_ALGO.WEEK14/P3197/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        L = new ArrayList<>();
        boundary = new LinkedList<>();
        boundaryPossible = new LinkedList<>();
        Q = new LinkedList<>();
        map = new char[R][C];
        ch = new int[R][C];
        ch2 = new int[R][C];
        char input;
        String inputStr;

        for(int i = 0; i < R; i++){
            inputStr = br.readLine();
            for(int j = 0; j < C; j++){
                input = inputStr.charAt(j);
                map[i][j] = input;

                if(input == '.') {
                    boundary.add(new Point(i, j));
                    ch[i][j] = 1;
                }
                if(input == 'L') { L.add(new Point(i, j)); }
            }
        }

        res = 0;
        Q.add(new Point(L.get(0).x, L.get(0).y));
        ch2[L.get(0).x][L.get(0).y] = 1;

        while(true){
            if(isPossible(L.get(0), L.get(1))) break;
            oneDay();
            res++;
        }
        System.out.println(res);
    }

    // 하루 지나서 물이 얼음을 녹이는 시뮬레이션
    static void oneDay(){
        Iterator<Point> it1 = boundary.iterator();
        while(it1.hasNext()){
            Point tmp = it1.next();
            //System.out.println(tmp.x + ", " + tmp.y);
        }
        //System.out.println();

        int size = boundary.size();

        for(int i = 0; i < size; i++){
            Point front = boundary.poll();

            for(int j = 0; j < 4; j++){
                int xx = front.x + dx[j];
                int yy = front.y + dy[j];

                //System.out.println("oneday탐색 :" + xx + ", " + yy);
                if(0 <= xx && xx < R && 0 <= yy && yy < C &&
                        map[xx][yy] == 'X' && ch[xx][yy] == 0){
                    map[xx][yy] = '.';
                    ch[xx][yy] = 1;                     // 새로 생긴 물을 체킹
                    boundary.add(new Point(xx, yy));    // 새로 생긴 물을 경계점에 넣어줌
                }
            }
        }
        //printMap();
    }

    // 백조 둘이 만날 수 있는지 반환(bfs)
    static boolean isPossible(Point L1, Point L2){

        while(!Q.isEmpty()){
            Point front = Q.poll();

            if(front.x == L2.x && front.y == L2.y){
                return true;
            }

            for(int i = 0; i < 4; i++){
                int xx = front.x + dx[i];
                int yy = front.y + dy[i];

                //System.out.println("ispossible탐색 :" + xx + ", " + yy);
                // 갈 수 있냐?
                if(0 <= xx && xx < R && 0 <= yy && yy < C
                        && ch2[xx][yy] == 0){

                    ch2[xx][yy] = 1;
                    if(map[xx][yy] == 'X'){
                        boundaryPossible.add(new Point(xx, yy));
                        continue;
                    }
                    Q.add(new Point(xx, yy));
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