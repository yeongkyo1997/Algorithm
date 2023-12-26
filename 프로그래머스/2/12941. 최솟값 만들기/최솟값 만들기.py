def solution(A,B):
    a = sorted(A)
    b = sorted(B, reverse = True)
    
    return sum(map(lambda x, y : x * y, a, b))
