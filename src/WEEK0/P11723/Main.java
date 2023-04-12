package WEEK0.P11723;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK0/P/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(order == "add"){
                
            } else if(order == "remove"){

            } else if(order == "check"){

            } else if(order == "toggle"){

            } else if(order == "all"){

            } else if(order == "empty"){

            }
        }
    }

}