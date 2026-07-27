/**
*  현재 인덱스에 해당하는 값을 + , - 한 경우를 dfs로 넘겨서 재귀호출로 구현
*  인덱스가 마지막이고 타겟넘버에 도달했다면 횟수증가 후 종료 아니더라도 종료
*  재시도 필요 X
*/
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(target,0,0,numbers);
        return answer;
    }
    
    static void dfs(int target,int curIndex, int curSum, int[] numbers){
        if(curIndex == numbers.length) {
            if(curSum == target) answer++;
            return;
        }
        dfs(target,curIndex+1,curSum-numbers[curIndex],numbers);
        dfs(target,curIndex+1,curSum+numbers[curIndex],numbers);
        
    }
}
