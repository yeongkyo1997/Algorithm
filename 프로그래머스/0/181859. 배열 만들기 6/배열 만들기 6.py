def solution(arr):
    result = []
    
    i = 0
    
    while i < len(arr):
        if result:
            if result[-1] == arr[i]:
                result.pop()
            else:
                result.append(arr[i])
        else:
            result.append(arr[i])
        
        i += 1
    
    return result if result else [-1]
