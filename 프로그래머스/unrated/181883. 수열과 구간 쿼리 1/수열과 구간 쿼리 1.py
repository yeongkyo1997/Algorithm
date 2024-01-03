def solution(arr, queries):
    for a, b in queries:
        arr[a:b + 1] = list(map(lambda x : x + 1, arr[a:b + 1]))
    
    return arr

        
        
        