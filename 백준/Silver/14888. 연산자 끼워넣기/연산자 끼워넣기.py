import math

N = int(input())

arr = list(map(int, input().split()))
calc = list(map(int, input().split()))
result_max = -math.inf
result_min = math.inf


def dfs(acc, depth, a, b, c, d):
    global result_max, result_min
    if a == b == c == d == 0:
        result_max = max(result_max, acc)
        result_min = min(result_min, acc)
        return

    if a > 0:
        dfs(acc + arr[depth], depth + 1, a - 1, b, c, d)
    if b > 0:
        dfs(acc - arr[depth], depth + 1, a, b - 1, c, d)
    if c > 0:
        dfs(acc * arr[depth], depth + 1, a, b, c - 1, d)
    if d > 0:
        dfs(int(acc / arr[depth]), depth + 1, a, b, c, d - 1)


dfs(arr[0], 1, calc[0], calc[1], calc[2], calc[3])
print(result_max)
print(result_min)