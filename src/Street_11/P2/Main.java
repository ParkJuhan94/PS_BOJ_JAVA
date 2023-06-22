package Street_11.P2;

class Solution {

    public int solution(String S) {

        int ans = 0;
        int numB = 0;
        int numA = 0;
        int numN = 0;

        // B , A , N 수 세기
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == 'B'){
                numB++;
            }
            else if(S.charAt(i) == 'A'){
                numA++;
            }
            else if(S.charAt(i) == 'N'){
                numN++;
            }
        }

        // BANANA 알파벳 숫자로 나눈 몫 중 최솟값을 리턴
        ans = Math.min(numB, numA / 3);
        ans = Math.min(ans, numN / 2);

        return ans;
    }
}


public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {

    }
}

