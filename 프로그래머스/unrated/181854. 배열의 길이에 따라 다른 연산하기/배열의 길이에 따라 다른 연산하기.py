def solution(arr, n):
    if len(arr) % 2 != 0:
        return [ele + n if i % 2 == 0 else ele for i, ele in enumerate(arr)]
    else:
        return [ele + n if i % 2 != 0 else ele for i, ele in enumerate(arr)]
