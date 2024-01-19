def solution(arr, k):
    result = []
    
    for i in arr:
        if not i in result:
            result.append(i)
        
    result += [-1] * 10001

    return result[:k]
