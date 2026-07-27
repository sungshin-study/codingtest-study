/**
* while에서 범위 방향 정하는게 어려웠음.
* 작은 값을 버리고 더 큰 값으로 간격이 되는지 확인하는 방식 
* check 안에서는 돌이 마지막 밟은 위치와의 거리가 목표 간격보다 작으면 좁은걸로 판단하고 해당 돌을 제거, 아니라면 마지막 밟은 위치를 현재 돌로 설정
* 재시도 필요
*/
import java.util.Arrays;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = -1;
        int lo = 0;
        int hi = distance;
        Arrays.sort(rocks);
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (check(mid,rocks,n,distance)){
                answer = mid; // 정답 후보로 저장
                lo = mid + 1; // 더 큰 값도 되는지 확인, 간격을 최대한 크게 만들어야 하므로 
            } else {
                hi = mid - 1;
            }
        }
        return answer;
    }
    static boolean check(int dist, int[] rocks, int n, int distance){
        int cnt = 0;
        int last = 0;
        for(int i = 0; i < rocks.length;i++){
            if(rocks[i] - last < dist) { 
                // 현재 바위 위치와 마지막 밟은 거리가 간격보다 작으면
                // 좁으므로 해당 돌 제거
                cnt++;
            } else {
                last = rocks[i];
            }
        }
        // 마지막 구간을 검사, 마지막 밟은 돌에서 마지막까지의 거리가 너무 좁다면 돌을 제거해야됨
        if (distance - last < dist) cnt++;
        return n >= cnt;
    }
}
