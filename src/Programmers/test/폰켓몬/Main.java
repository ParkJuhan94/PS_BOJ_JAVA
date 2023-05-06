package Programmers.test.폰켓몬;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int[] nums = {3, 1, 2, 3};
        int[] nums1 = {3, 3,3,2,2,4};
        int[] nums2 = {3,3,3,2,2,2};

        System.out.println(s.solution(nums));
        System.out.println(s.solution(nums1));
        System.out.println(s.solution(nums2));
    }
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        // 중복 제거하기
        HashSet<Integer> map = new HashSet<>();
        for(int num : nums){
            map.add(num);
        }

        if(map.size() > max){
            answer = max;
        }else{
            answer = map.size();
        }

        return answer;
    }
}