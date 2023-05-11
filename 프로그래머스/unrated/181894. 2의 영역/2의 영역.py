def solution(arr):
    if 2 not in arr:
        return [-1]
    
    start = end = -1
    
    for i in range(len(arr)):
        if arr[i] == 2:
            start = i
            end = i
            break
    
    for i in range(start+1, len(arr)):
        if arr[i] == 2:
            end = i
            if end - start < end - arr.index(2):
                start = arr.index(2, start+1)
                end = i
    
    return arr[start:end+1]
