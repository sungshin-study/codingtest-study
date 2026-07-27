class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,0,0,target);
    }
    
    private int dfs(int[] numbers, int idx, int sum, int target){
        if(idx == numbers.length){
            return sum == target? 1:0;
        }
        int add = dfs(numbers, idx+1,sum+numbers[idx], target);
        int sub = dfs(numbers, idx+1, sum-numbers[idx], target);
        
        return add+ sub;
    }
}