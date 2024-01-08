from collections import deque

def solution(A, B):
    q_a = deque(A)
    q_b = deque(B)
    
    for i in range(len(A)):
        if q_a == q_b:
            return i
        q_a.rotate(1)
    return -1