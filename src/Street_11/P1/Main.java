package Street_11.P1;

class Solution {
    public int solution(String S) {
        int ans = 0;
        int len = S.length();
        int p1 = 0;
        int p2 = len - 1;

        for(int i = 0; i < len; i++){
            if(S.charAt(p1) == S.charAt(p2)){
                ans++;
            }

            p1++;
            p2 = (p2 + 1) % len;
        }

        return ans;
    }
}


public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {

    }
}

