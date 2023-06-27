package Programmers.Level_2.조이스틱;

// https://velog.io/@eora21/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.2-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-Java-Python

class Solution {
    public int solution(String name) {
        int answer = 0;
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        for(char c : name.toCharArray())
            answer+=diff[c-'A'];

        int length=name.length();
        int min=length-1;

        // 사이의 A를 피하기
        for(int i=0;i<length;i++){
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }
            min=Math.min(min,i+length-next+Math.min(i,length-next));
        }

        return answer+min;
    }
}

/* 97점
class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;
        int verticalMove = 0;
        boolean onlyA = true;

        int lastNotA = 0;
        for(int i = 0; i < len; i++){
            if(name.charAt(i) != 'A') {
                onlyA = false;
                lastNotA = i;
            }
        }
        if(onlyA) return 0;

        // 좌우 1 : 처음부터 끝까지 쭉
        int horizontalMove = Math.min(len - 1, lastNotA);

        for(int i = 0; i <= len - 1; i++){
            // 상하
            verticalMove = Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            answer += verticalMove;

//               startA endA  len-1
//                   ↓  ↓      ↓
//                BB{AAAA}B{AA}B
//
//                A 그룹이 여러번 나올 수 있는데, A 그룹마다 탐색해줘야 해
//
//                AAAABBAA
//
//                ABBAAAABA

            if(name.charAt(i) == 'A'){
                int startA = i;     // A 그룹 시작 인덱스
                int endA = i;       // A 그룹 마지막 인덱스

                int flag = 0;
                // 조이스틱이 왼쪽으로 뛰어넘어서 A 그룹 생성하는거 체크
                if(startA == 0){
                    while(startA - 1 >= ((-1) * len + 2) &&
                            name.charAt(startA - 1 + len) == 'A'){
                        startA--;
                        flag = 1;
                    }
                }
                while(endA + 1 <= len - 1 && name.charAt(endA + 1) == 'A'){
                    endA++;
                }

                if(flag == 0){
                    // 좌우 2 : 오른쪽 -> 왼쪽
                    horizontalMove = Math.min(horizontalMove, (startA - 1) * 2 + (len - 1 - endA));
                    System.out.println("좌우2 : " + horizontalMove);

                    // 좌우 3 : 왼쪽 -> 오른쪽
                    horizontalMove = Math.min(horizontalMove, (len - 1 - endA) * 2 + (startA - 1));
                    System.out.println("좌우3 : " + horizontalMove);
                }else{
                    int numNotA = len - (endA + 1 + Math.abs(startA));
                    horizontalMove = Math.min(horizontalMove, numNotA + endA);
                    horizontalMove = Math.min(horizontalMove, numNotA + Math.abs(startA));
                }
            }
        }

        answer += horizontalMove;

        return answer;
    }
}
*/

public class Main {

    static Solution s = new Solution();

    public static void main(String[] args) {

    }
}

