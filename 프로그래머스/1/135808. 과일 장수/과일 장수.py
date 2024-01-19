def solution(k, m, score):
    score.sort()
    result = 0
    
    for i in range(len(score) - m, -1, -m):
        result += score[i] * m
        
    return result
