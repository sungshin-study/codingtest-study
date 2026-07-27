def solution(numbers, target):
    answer = 0
    idx = 0 
    len_nums = len(numbers)
    ans_sum = 0
    total_count = 0
    
    #dfs 
    def dfs(idx , ans_sum):
        if idx == len_nums: #제일 끝에 도달을 함
            if ans_sum == target: #제일 끝에 도달했을 때 타겟변수가 동일한지 체크 
                return 1
            else:
                return 0
            
        # +- 인 경우가 각각 있으므로 두가지 경우의 수     
        plus_count = dfs(idx+1,ans_sum + numbers[idx]) 
        minus_count = dfs(idx+1,ans_sum - numbers[idx])
        
        total_count = plus_count + minus_count
        return total_count
    
    answer = dfs(0, 0)
    return answer
