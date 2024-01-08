def solution(arr):
    try:
        start = arr.index(2)
        end = len(arr) - arr[::-1].index(2)
        return arr[start:end]
    except:
        return [-1]
            