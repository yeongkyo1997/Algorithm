import math

N = int(input())
s = input().rstrip()


def calc(a, op, b):
    a = int(a)
    b = int(b)
    if op == '+':
        return a + b
    if op == '-':
        return a - b
    if op == '*':
        return a * b


def dfs(acc, idx):
    global result

    if idx == N - 1:
        result = max(result, acc)
        return

    # 괄호X
    if N > idx + 2:
        dfs(calc(acc, s[idx + 1], s[idx + 2]), idx + 2)
    if N > idx + 4:
        dfs(calc(acc, s[idx + 1], calc(s[idx + 2], s[idx + 3], s[idx + 4])), idx + 4)


result = -math.inf
dfs(int(s[0]), 0)
print(result)