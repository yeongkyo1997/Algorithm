def solution(N, stages):
    result = []
    for i in range(1, N + 1):
        cant = 0
        total = 0
        
        for j in stages:
            if j >= i:
                total += 1
            if j == i:
                cant += 1
        if total == 0:
            result.append((i, 0))
        else:
            result.append((i, cant / total))
    
    return [i for i, _ in sorted(result, key=lambda x:-x[1])]