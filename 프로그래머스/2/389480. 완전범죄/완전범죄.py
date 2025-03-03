def solution(info, n, m):
    dp = {(0, 0)}
    
    for a_cost, b_cost in info:
        next_dp = set()
        for a, b in dp:
            if a + a_cost < n:
                next_dp.add((a + a_cost, b))
            if b + b_cost < m:
                next_dp.add((a, b + b_cost))
        dp = next_dp
        
        if not dp:
            return -1

    answer = min(a for a, b in dp)
    return answer
