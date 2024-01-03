def solution(arr, flag):
    result = []
    for a, b in zip(arr, flag):
        if b:
            result += [a] * (a * 2)
        else:
            [result.pop() for _ in range(a)]

    return result
