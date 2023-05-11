from collections import defaultdict

def solution(strArr):
    dic = defaultdict(int)
    
    for i in strArr:
        dic[len(i)] += 1
    
    result = 0
    for i in range(31):
        result = max(result, dic[i])
    
    return result