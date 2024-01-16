def solution(arr):
    stack = [arr[:]]
    result = 0

    while True:
        t = trans(stack[-1])
        result += 1

        if t == stack.pop():
            return result - 1
        stack.append(t)


def trans(arr):
    result = []

    for i in arr:
        if i >= 50 and i % 2 == 0:
            result.append(i // 2)
        elif i < 50 and i % 2 != 0:
            result.append(i * 2 + 1)
        else:
            result.append(i)
    return result


solution([1, 2, 3, 100, 99, 98])
