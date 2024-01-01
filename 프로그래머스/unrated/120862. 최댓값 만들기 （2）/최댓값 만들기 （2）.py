def solution(numbers):
    numbers.sort(reverse=True)
    
    plus, minus = [], []
    
    for i in numbers:
        if i >= 0:
            plus.append(i)
        else:
            minus.append(i)
    
    if len(plus) >= 2 and len(minus) >= 2:
        return max(plus[0] * plus[1], minus[-1] * minus[-2])
    else:
        if len(plus) < 2 and len(minus) < 2:
            return plus[0] * minus[0]
        elif len(plus) < 2:
            return minus[-1] * minus[-2]
        else:
            return plus[0] * plus[1]