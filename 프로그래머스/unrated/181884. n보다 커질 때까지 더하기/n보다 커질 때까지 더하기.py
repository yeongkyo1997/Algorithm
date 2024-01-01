def solution(numbers, n):
    result = 0
    i = 0
    
    while result <= n:
        result += numbers[i]
        i += 1
    
    return result