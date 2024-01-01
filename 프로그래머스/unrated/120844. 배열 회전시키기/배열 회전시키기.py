from collections import deque

def solution(numbers, direction):
    q = deque(numbers)
    
    if direction == 'right':
        q.rotate(1)
        result =  list(q)
    else:
        q.rotate(-1)
        result = list(q)
    
    return result
    
    