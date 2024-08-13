import math

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

result = -math.inf


def dfs(total, depth):
    global result
    if depth >= N:
        result = max(result, total)
        return

    a, b = arr[depth]

    if depth + a <= N:
        dfs(total + b, depth + a)
    dfs(total, depth + 1)


dfs(0, 0)
print(result)