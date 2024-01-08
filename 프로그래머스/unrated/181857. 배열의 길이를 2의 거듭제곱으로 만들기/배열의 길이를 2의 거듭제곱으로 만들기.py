def solution(arr):
    for i in range(100):
        if len(arr) == (1 << i):
            return arr
        elif len(arr) < (1 << i):
            return arr + [0 for _ in range((1 << i) - len(arr))]        