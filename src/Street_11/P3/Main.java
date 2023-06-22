package Street_11.P3;

class Solution {
    public int solution(String S, int[] C) {

        int ans = 0;
        int len = S.length();
        int minus = 0;
        int plus = 0;
        int flag = 0;

        // 실제로 삭제 안하고, 삭제한거처럼 인덱싱만
        for(int i = 0; i < len - 1; i++){
            // 1. 삭제해
            if(equalSide(S, i, minus, plus)){
                if(C[i] >= C[i + 1])    // 뒤 삭제
                {
                    ans += C[i + 1];
                    i--;
                    plus++;
                }
                else {                      // 앞 삭제
                    ans += C[i];
                    i--;
                    minus--;
                }
            }

            // 2. 삭제 안 해
        }

        return ans;
    }

    public boolean equalSide(String S, int idx, int minus, int plus){
        if(S.charAt(idx - minus) == S.charAt(idx + 1 + plus)){
            return true;
        }else{
            return false;
        }
    }
}

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {

    }
}

