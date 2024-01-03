def solution(arr1, arr2):
    result = [[0] * len(arr1[0]) for _ in range(len(arr1))]
    
    for i in range(len(arr1)):
        for j in range(len(arr1[0])):
            result[i][j] = arr1[i][j] + arr2[i][j]
            
    return result
            