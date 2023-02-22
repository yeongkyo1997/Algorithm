alphabet = 'ABCDEF'
dic = {i + 10: x for i, x in enumerate(list(alphabet), 0)}


def change(c, n):
    result = ''

    while c:
        c, mod = divmod(c, n)
        if mod >= 10:
            result += dic[mod]
        else:
            result += str(mod)
    return result[::-1]


def solution(n, t, m, p):
    tmp = '0'
    i = 1
    while len(tmp) < t * m + p:
        tmp += change(i, n)
        i += 1
    return tmp[p - 1:t * m:m]
