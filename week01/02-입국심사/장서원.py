def solution(n, times):
    answer = 0
    # 걸리는 시간의 최소를 구하는 것이므로, 1~ max(times)*n까지 중에 이진탐색
    left = 1
    right = max(times) * n
    answer = right
    
    while left <= right: # 정확한 key를 찾을 때까지
        mid = (left+right)//2
        cnt = 0
        
        for t in times:
            cnt += mid//t # 각 심사관이 처리할 수 있는 인원
        if cnt >= n: # 총 심사관 처리 인원이 처리해야 하는 인원n보다 큼
            answer = mid
            right = mid -1
        else:
            left= mid +1
    return answer