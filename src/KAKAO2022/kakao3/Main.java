package KAKAO2022.kakao3;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        answer = new int[privacies.length];
        int idx = 0;
        HashMap<String, String> map = new HashMap<String, String>();

        String[] todayArr = today.split("[.]");
        int ty = Integer.parseInt(todayArr[0]);
        int tm = Integer.parseInt(todayArr[1]);
        int td = Integer.parseInt(todayArr[2]);

        for (int i = 0; i < terms.length; i++) {
            String str = terms[i];
            String[] strArr = str.split(" ");
            map.put(strArr[0], strArr[1]);
        }

        for (int i = 0; i < privacies.length; i++) {
            String str = privacies[i];
            String[] strArr = str.split(" ");
            String alpha = strArr[1];

            String[] dateArr = strArr[0].split("[.]");
            int m_ = Integer.parseInt(dateArr[1]);
            m_ += Integer.parseInt(map.get(alpha));

            int y = Integer.parseInt(dateArr[0]);
            int m = m_;
            int d = Integer.parseInt(dateArr[2]);
            d--;
            if (d == 0) {
                d = 28;
                m -= 1;
            }
            System.out.println(y + "." + m + "." + d);

            if (m > 12) {
                while (true) {
                    m -= 12;
                    y += 1;

                    if (m <= 12) {
                        break;
                    }
                }
            }

            if (m == 0) {
                m = 12;
                y -= 1;
            }

            System.out.println(y + "." + m + "." + d);
            System.out.println();

            // 비교
            int input = i + 1;
            if (y < ty) {
                answer[idx++] = input;
                continue;
            } else if (y == ty) {
                if (m < tm) {
                    answer[idx++] = input;
                    continue;
                } else if (m == tm) {
                    if (d < td) {
                        answer[idx++] = input;
                        continue;
                    }
                }
            }
        }

        answer = Arrays.copyOfRange(answer, 0, idx);

        return answer;
    }
}

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B",
                "2022.02.19 C", "2022.02.20 C"};

         //[1, 3] 이 출력돼야해
        int[] res = s.solution(today, terms, privacies);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }

    }
}