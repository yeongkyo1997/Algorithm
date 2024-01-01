def solution(arr, intervals):
    return [i for a, b in intervals for i in arr[a:b + 1]]