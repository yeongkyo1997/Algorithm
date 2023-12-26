def solution(t, p):
    arr = []
    
    for i in range(0, len(t) - len(p) + 1):
        arr.append(t[i:i + len(p)])
    
    return sum(1 for i in arr if int(p) >= int(i))