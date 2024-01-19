def solution(arr, k):
    result = []
    
    for i in arr:
        if not i in result:
            result.append(i)
        
    if len(result) > k:
        return result[:k]
    elif len(result) < k:
        return result + [-1] * (k - len(result))
    else:
        return result