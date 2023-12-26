def solution(d, budget):
    result = 0
    
    d = sorted(d)
    
    for i in d:
        if budget >= i:
            result += 1
            budget -= i
    
    return result