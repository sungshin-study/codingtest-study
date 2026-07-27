import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        Arrays.sort(
                costs, (a, b) -> Integer.compare(a[2], b[2])
        );

        for (int i = 0; i < costs.length; i++ ) {
            int[] cost = costs[i];
            int start = cost[0];
            int end = cost[1];
            int c = cost[2];

            if (union(start, end)) {
                answer += c;
            }
        }

        return answer;
    }

    public boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return false;
        }

        if (a != b) {
            parent[a] = b;


        }

        return true;
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}