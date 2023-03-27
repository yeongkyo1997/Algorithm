import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

L, C = map(int, input().split())

inputs = list(input().split())

inputs.sort()


def check(pwd):
    j = 0
    m = 0
    for i in range(len(pwd)):
        if pwd[i] in ['a', 'e', 'i', 'o', 'u']:
            m += 1
        else:
            j += 1
    if j >= 2 and m >= 1:
        return True
    else:
        return False


def combination(cnt, start):
    if cnt == L:
        if check(pwd):
            print(''.join(pwd))
        return
    for i in range(start, C):
        pwd[cnt] = inputs[i]
        combination(cnt + 1, i + 1)


pwd = [''] * L
combination(0, 0)