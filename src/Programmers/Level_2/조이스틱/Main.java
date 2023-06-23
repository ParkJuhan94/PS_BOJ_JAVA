package Programmers.Level_2.조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int sumLeft = 0;
        int sumRight = 0;

        int cnt = 0;
        int max = 0;
        int p1 = 0;
        int p2 = len - 1;
        // A 가 제일 많이 연속되는 부분 찾기
        for(int i = 0; i < len - 1; i++){
            if(name.charAt(i) == 'A'){
                cnt++;
                if(cnt >= max){
                    max = cnt;
                    p1 = i;
                }
            }else{
                cnt = 0;
            }
        }

        // 처음 커서에서 오른쪽으로 이어진 A 의 갯수
        for(int i = 0; i < len - 1; i++){
            if(name.charAt(1 + i) == 'A'){
                sumRight++;
            }else{
                break;
            }
        }

        // 좌 혹은 우 이동 횟수
        answer += Math.min(len - 1 - sumLeft,
                           len - 1 - sumRight);

        // 알파벳 조정
        for(int i = 0; i < len; i++){
            if(name.charAt(i) != 'A'){
                int diff = name.charAt(i) - 'A';
                answer += Math.min(diff, 26 - diff);
            }
        }

        return answer;
    }
}

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {

    }
}

