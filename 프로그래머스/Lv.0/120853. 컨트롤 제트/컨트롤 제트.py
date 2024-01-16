def solution(s):
    result = []
    
    s = s.split()
    
    for i in s:
        if i == 'Z':
            result.pop()
        else:
            result.append(int(i))
    
    return sum(result)
        
