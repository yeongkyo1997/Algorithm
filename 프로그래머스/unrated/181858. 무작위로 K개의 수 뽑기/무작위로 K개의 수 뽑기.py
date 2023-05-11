def solution(arr, k):
    n = len(arr)
    result = []
    for i in range(n):
        if arr[i] not in result:
            result.append(arr[i])
            if len(result) == k:
                return result
    while len(result) < k:
        result.append(-1)
    return result
