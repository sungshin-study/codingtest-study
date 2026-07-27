#이분탐색 문제 -> 중간값을 하나 찍어서 그게 원하는 값보다 큰가 작은가만 판단하면 됨
def solution(n, times):
    answer = 0
    
    low = 1 #최소 
    high = max(times) * n # 최대 
    
    while low<= high:
        mid = (low + high ) //2 #중간값부터 시작
        
        count_man = 0 
        # 주어진 t 에 몇명을 심사할수있을지 
        for t in times:
            count_man += mid // t #중간값부터 탐색
    
        if count_man >= n: #탐색 가능한 인원 >= 탐색해야 하는 인원?
            answer = mid
            high = mid -1 #가능 -> t를 더 줄일 수 있을지 while~
        else:
            low = mid + 1 #불가능 -> 탐색 불가하니 최소값을 올리기
    return answer
