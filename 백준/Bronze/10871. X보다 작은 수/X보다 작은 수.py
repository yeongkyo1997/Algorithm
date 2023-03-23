import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n, x = map(int, input().split())
print(*[i for i in map(int, input().split()) if i < x])
