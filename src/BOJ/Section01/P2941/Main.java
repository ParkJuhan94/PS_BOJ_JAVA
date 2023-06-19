package BOJ.Section01.P2941;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ.Section01/P2941/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        String str = br.readLine();

        while(true){
            int minIdx = 1000;
            String alpha = "";
            for(int i = 0; i < arr.length; i++){
                if(str.contains(arr[i])){
                    if(str.indexOf(arr[i]) < minIdx){
                        minIdx = str.indexOf(arr[i]);
                        alpha = arr[i];
                    }
                }
            }

            if(alpha == ""){
                break;
            }

            int idx = str.indexOf(alpha);
            str = str.replaceFirst(alpha,"");
            cnt+= idx;
            cnt++;

            str = str.substring(idx);
            //System.out.println("str : " + str);

        }

        System.out.println(cnt + str.length());
    }

}