def solution(hp):
    result = 0
    
    result += hp // 5
    hp %= 5
    
    result += hp // 3
    hp %= 3
    
    result += hp
    
    return result