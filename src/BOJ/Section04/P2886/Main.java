package BOJ.Section04.P2886;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int ans = 0;
    static ArrayList<Point> seats;
    static ArrayList<Point> person;
    static int[] dr = {-1 , 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/Section04/P2886/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        seats = new ArrayList<>();
        person = new ArrayList<>();

        for(int i = 0; i < R; i++){
            String input = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'L'){
                    seats.add(new Point(i, j));
                }else if(map[i][j] == 'X'){
                    person.add(new Point(i, j));
                }
            }
        }

        search();

        System.out.println(ans);
    }

    static void search(){
        double min = Integer.MAX_VALUE;
        Map<Double, Integer> map = new HashMap<>();

        // 완탐
        for(int i = 0; i < seats.size(); i++){
            Point seat = seats.get(i);

            for(int j = 0; j < person.size(); j++){
                Point cur = person.get(j);
                double dist = Math.pow(cur.r - seat.r, 2) + Math.pow(cur.c - seat.c, 2);

                if(dist < min){
                    min = dist;
                }

                if(map.containsKey(dist)){
                    map.put(dist, map.get(dist) + 1);
                }else{
                    map.put(dist, 1);
                }
            }

            if(map.get(min) >= 2){
                ans++;
            }
        }
    }

}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}