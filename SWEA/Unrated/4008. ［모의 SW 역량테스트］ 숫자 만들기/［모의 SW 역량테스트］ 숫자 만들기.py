import math


def dfs(total, depth, a, b, c, d):
    global max_val, min_val
    if depth >= N:
        max_val = max(total, max_val)
        min_val = min(total, min_val)
        return

    if a > 0:
        dfs(total + arr[depth], depth + 1, a - 1, b, c, d)
    if b > 0:
        dfs(total - arr[depth], depth + 1, a, b - 1, c, d)
    if c > 0:
        dfs(total * arr[depth], depth + 1, a, b, c - 1, d)
    if d > 0:
        dfs(math.trunc(total / arr[depth]), depth + 1, a, b, c, d - 1)


for t in range(1, int(input()) + 1):
    N = int(input())
    a, b, c, d = map(int, input().split())
    arr = list(map(int, input().split()))
    max_val = -math.inf
    min_val = math.inf
    dfs(arr[0], 1, a, b, c, d)
    print(f'#{t} {max_val - min_val}')
