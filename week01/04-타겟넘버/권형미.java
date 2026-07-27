import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers,0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int value, int target) {
        if (depth == numbers.length && value == target) {
            answer++;
            return;
        }

        if (depth == numbers.length && value != target) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newValue = (i == 0) ? value + numbers[depth] : value - numbers[depth];
            dfs(numbers, depth + 1, newValue, target);
        }
    }
}