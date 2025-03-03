def solution(numbers):
    s = set()
    
    for i, n1 in enumerate(numbers):
        for j, n2 in enumerate(numbers):
            if i != j:
                s.add(n1 + n2)
            
    return sorted(s)