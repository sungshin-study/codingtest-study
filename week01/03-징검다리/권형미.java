import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;

        Arrays.sort(rocks);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int removed = 0;  // 제거한 바위 개수
            int prev = 0;  // 마지막으로 남겨둔 바위

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removed++;
                } else {
                    prev = rock;
                }
            }

            if (distance - prev < mid) {
                removed++;
            }

            if (removed <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}