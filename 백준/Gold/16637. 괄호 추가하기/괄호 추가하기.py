import math
import sys



# 계산하는 함수
def calc(a, op, b):
    a = int(a)
    b = int(b)

    if op == '+':
        return a + b
    if op == '-':
        return a - b
    if op == '*':
        return a * b


def dfs(depth, total):
    if depth >= N:
        return total

    ret = -math.inf
    # 괄호가 없다면
    if depth + 1 < N:
        ret = max(dfs(depth + 2, calc(total, exp[depth], exp[depth + 1])), ret)
    # 괄호가 있다면
    if depth + 3 < N:
        ret = max(dfs(depth + 4, calc(total, exp[depth], calc(exp[depth + 1], exp[depth + 2], exp[depth + 3]))),
                  ret)

    return ret


if __name__ == '__main__':
    N = int(input())
    exp = list(input())

    print(dfs(1, int(exp[0])))
