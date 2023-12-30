def solution(n, control):
    result = n
    
    for i in control:
        if i == 'w':
            result += 1
        if i == 's':
            result -= 1
        if i == 'd':
            result += 10
        if i == 'a':
            result -= 10
        
    return result
            