import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            graph[start].add(new int[]{end, cost});
            graph[end].add(new int[]{start, cost});
        }

        for (int[] node : graph[0]) {
            pq.offer(node);
            visited[0] = true;
            count = 1;
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (visited[cur[0]]) {
                continue;
            }

            visited[cur[0]] = true;
            answer += cur[1];
            count++;

            if (count == n) {
                break;
            }

            for (int[] node : graph[cur[0]]) {
                if (!visited[node[0]]) {
                    pq.offer(node);
                }
            }
        }

        return answer;
    }
}