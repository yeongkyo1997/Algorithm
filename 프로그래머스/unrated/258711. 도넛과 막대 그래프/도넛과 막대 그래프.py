from collections import defaultdict

def solution(edges):
    result = [0] * 4
    give = defaultdict(int)
    recive = defaultdict(int)
    
    cnt = max(max(a, b) for a, b in edges)

    for a, b in edges:
        give[a] += 1
        recive[b] += 1
    
    for i in range(1, cnt + 1):
        if recive[i] == 0 and give[i] >= 2:
            result[0] = i
        elif recive[i] >= 2 and give[i] >= 2:
            result[3] += 1
        elif give[i] == 0:
            result[2] += 1
    
    result[1] = give[result[0]] - result[2] - result[3]
    
    return result