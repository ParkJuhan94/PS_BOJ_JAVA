package Programmers.Level_2.이모티콘할인행사;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int numUser = users.length;
        int numEmo = emoticons.length;

        /*
        1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        2. 이모티콘 판매액을 최대한 늘리는 것.

        1번 목표가 우선이며, 2번 목표가 그 다음입니다.
         */

//        각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
//        각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면,
//        이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.

        int resNumJoin = 0;    // 서비스 가입자
        int resSales = 0;      // 총 판매액

        for (int k = 40; k >= 0; k--)
        {
            int numJoin = 0;    // 서비스 가입자
            int sales = 0;      // 총 판매액

            for (int i = 0; i < numUser; i++) {
                int sumPay = 0;

                for (int j = 0; j < numEmo; j++) {
                    sumPay += emoticons[j] * k / 100;
                }

                sales += sumPay;
                if (joinService(users[i], sumPay)) {
                    numJoin++;
                }
            }

            // 서비스 가입자와 총 판매액을 갱신
            if(numJoin >= resNumJoin){

            }
        }








        return answer;
    }

    boolean joinService(int[] user, int sumPay){
        if(sumPay >= user[1]){
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

