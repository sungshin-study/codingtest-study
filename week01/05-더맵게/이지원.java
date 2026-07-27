import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : scoville){
            q.add(s);
        }
        // k 이상으로 만드려면 섞어야 하는 최소 횟수
        while(!q.isEmpty()){
            if(q.peek() >= K) break;
            int a,b;
            a = q.poll();
            if(!q.isEmpty()){
                b = q.poll();
            } else {
                return -1;
            }
            q.add(a + b*2);
            answer++;
        }
        return answer;
    }
}
