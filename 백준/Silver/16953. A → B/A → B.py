import sys

input = sys.stdin.readline

result = 10 ** 10

arr, b = map(int, input().split())


def dfs(cur, cnt):
    global result

    if cur == b:
        result = min(result, cnt)
        return
    if cur > b:
        return
    dfs(cur * 2, cnt + 1)
    dfs(cur * 10 + 1, cnt + 1)


dfs(arr, 1)
if result == 10 ** 10:
    print("-1")
else:
    print(result)
