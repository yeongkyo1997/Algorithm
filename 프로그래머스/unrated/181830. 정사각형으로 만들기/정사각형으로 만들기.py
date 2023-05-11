def solution(arr):
    max_len = max(len(arr), len(arr[0]))
    return [[arr[i][j] if i < len(arr) and j < len(arr[i]) else 0 for j in range(max_len)] for i in range(max_len)]
