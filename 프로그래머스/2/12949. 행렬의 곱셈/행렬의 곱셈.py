def solution(arr1, arr2):
    n1, m1 = len(arr1), len(arr1[0])
    n2, m2 = len(arr2), len(arr2[0])
    result = [[0] * m2 for _ in range(n1)]
    
    for i in range(n1):
        for j in range(m2):
            for k in range(m1):
                result[i][j] += arr1[i][k] * arr2[k][j]
    return result
    