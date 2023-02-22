def solution(t, p):
    length = len(p)
    result = 0

    for i in range(len(t) - length + 1):
        tmp = t[i:i + length]
        tmp = int(''.join(tmp))
        if tmp <= int(p):
            result += 1

    return result
