import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = []


def dfs(num):
    if len(arr) == m:
        print(" ".join(map(str, arr)))
        return
    for i in range(num, n + 1):
        arr.append(i)
        dfs(i)
        arr.pop()


dfs(1)
