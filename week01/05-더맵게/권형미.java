import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> a - b
        );
        for (int s : scoville) {
            pq.offer(s);
        }

        while(true) {
            if (pq.size() < 2) {
                if (pq.peek() >= K) {
                    return answer;
                }
                return -1;
            }

            int cur = pq.poll();

            if (cur >= K) {
                return answer;
            }

            int next = pq.poll();
            pq.offer(cur + 2 * next);
            answer++;
        }
    }
}