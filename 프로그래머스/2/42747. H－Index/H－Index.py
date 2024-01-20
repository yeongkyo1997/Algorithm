def solution(citations):
    result = 0
    for i in range(max(citations)):
        used = sum(1 for j in citations if j >= i)
        unused = i - used
        if used >= i and unused <= i:
            result = max(result, i)
            
    return result
